package com.utkarsh.ecommercebackend.services;

import com.utkarsh.ecommercebackend.pojo.User;

public interface UserService {
public void registerUser(User user);
public boolean loginUser(String email, String password);
}
