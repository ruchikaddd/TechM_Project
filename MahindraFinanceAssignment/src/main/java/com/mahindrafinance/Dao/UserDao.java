package com.mahindrafinance.Dao;

import java.util.List;

import com.mahindrafinance.Model.User;

public interface UserDao {

	public void saveDatabaseObject(User user);
	public List<User> getAllDataBaseObjects();
}
