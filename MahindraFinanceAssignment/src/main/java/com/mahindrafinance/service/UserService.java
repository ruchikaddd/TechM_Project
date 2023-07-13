package com.mahindrafinance.service;

import com.mahindrafinance.Model.User;

public interface UserService {

	String createUser(User user);

	String retrieveUserId(String email);	
}
