package com.utkarsh.ecommercebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.utkarsh.ecommercebackend.pojo.User;

public interface UserRepository extends CrudRepository<User, Integer>{
public User findByEmail(String email);
}
