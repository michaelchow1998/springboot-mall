package com.michael.springbootmall.controller;

import com.michael.springbootmall.constant.ProductCategory;
import com.michael.springbootmall.dto.ProductQueryParams;
import com.michael.springbootmall.dto.ProductRequest;
import com.michael.springbootmall.model.Product;
import com.michael.springbootmall.service.ProductService;
import com.michael.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public  ResponseEntity<Page<Product>> getProducts(
            //Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            //Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // get product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //get total product number
        Integer total = productService.countProduct(productQueryParams);

        //Pagination
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if (product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
         Integer productId = productService.createProduct(productRequest);

         Product product = productService.getProductById(productId);

         return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                  @RequestBody @Valid ProductRequest productRequest
                                                  ){
        //check product not empty
        Product product = productService.getProductById(productId);
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //update product
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return  ResponseEntity.status(HttpStatus.OK).body(updatedProduct);

    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        //check product not empty
        Product product = productService.getProductById(productId);

        //delete product by productId
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
