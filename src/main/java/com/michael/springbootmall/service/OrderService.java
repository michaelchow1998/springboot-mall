package com.michael.springbootmall.service;

import com.michael.springbootmall.dto.CreateOrderRequest;
import com.michael.springbootmall.dto.OrderQueryParams;
import com.michael.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
