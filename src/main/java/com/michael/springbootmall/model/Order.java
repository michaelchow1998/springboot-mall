package com.michael.springbootmall.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {

    private Integer orderId;
    private Integer userId;
    private Integer totalAmount;
    private Date createDate;
    private Date lastModifiedDate;

    private List<OrderItem> orderItemList;
}
