package com.michael.springbootmall.service;

import com.michael.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
}