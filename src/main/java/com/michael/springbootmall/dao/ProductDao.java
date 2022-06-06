package com.michael.springbootmall.dao;

import com.michael.springbootmall.dto.ProductRequest;
import com.michael.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
