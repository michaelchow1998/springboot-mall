package com.michael.springbootmall.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderQueryParams {
    Integer userId;
    Integer limit;
    Integer offset;

}
