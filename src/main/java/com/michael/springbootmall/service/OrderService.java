package com.michael.springbootmall.service;

import com.michael.springbootmall.dto.CreateOrderRequest;
import com.michael.springbootmall.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
