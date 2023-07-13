package com.mahindrafinance.service.Impl;

import org.springframework.stereotype.Service;

import com.mahindrafinance.Model.User;
import com.mahindrafinance.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Override
	public String createUser(User user) {
		User dataToBeStored = new User();
		dataToBeStored.setName(user.getName());
		dataToBeStored.setEmail(user.getEmail());
		dataToBeStored.setPassword(user.getPassword());
		
		System.out.println(" dataToBeStored : "+dataToBeStored.toString());
		
		return "1234567890"; // Return the generated user ID
	}

	@Override
	public String retrieveUserId(String email) {
		return "1234567890"; // Return the generated user ID
	}
	}
