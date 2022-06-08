package com.michael.springbootmall.service;

import com.michael.springbootmall.dto.UserRegisterRequest;
import com.michael.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);


}
