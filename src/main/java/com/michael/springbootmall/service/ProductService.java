package com.michael.springbootmall.service;

import com.michael.springbootmall.dto.ProductRequest;
import com.michael.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
