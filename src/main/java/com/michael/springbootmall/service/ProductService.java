package com.michael.springbootmall.service;

import com.michael.springbootmall.constant.ProductCategory;
import com.michael.springbootmall.dto.ProductQueryParams;
import com.michael.springbootmall.dto.ProductRequest;
import com.michael.springbootmall.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

}
