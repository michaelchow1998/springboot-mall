package com.michael.springbootmall.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {

    private Integer orderId;
    private Integer userId;
    private Integer totalAmount;
    private Date createDate;
    private Date lastModifiedDate;

}
