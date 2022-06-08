package com.michael.springbootmall.dao;

import com.michael.springbootmall.dto.UserRegisterRequest;
import com.michael.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);


}
