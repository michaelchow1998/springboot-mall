package com.michael.springbootmall.service.impl;

import com.michael.springbootmall.dao.ProductDao;
import com.michael.springbootmall.model.Product;
import com.michael.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }
}