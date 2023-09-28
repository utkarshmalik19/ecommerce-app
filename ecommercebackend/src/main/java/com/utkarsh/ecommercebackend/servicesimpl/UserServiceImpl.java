package com.utkarsh.ecommercebackend.servicesimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.ecommercebackend.dao.UserRepository;
import com.utkarsh.ecommercebackend.pojo.User;
import com.utkarsh.ecommercebackend.services.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository userRepository;

	@Override
	public void registerUser(User user) {
		userRepository.save(user);

	}

	@Override
	public boolean loginUser(String email, String password) {
		User user = userRepository.findByEmail(email); 
		if(user == null) {
		return false;
		}
		return password.equals(user.getPassword());
	}

}
