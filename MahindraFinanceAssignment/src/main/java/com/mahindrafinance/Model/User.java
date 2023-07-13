package com.mahindrafinance.Model;

import java.util.List;

public class User {
	
	private String userId;
	private String name;
    private String email;
    private String password;
	private List<Advisor> advisorsAssignedToUser;
    
	public User() {
		super();
	}

	public User(String userId,String name, String email, String password, List<Advisor> advisorsAssignedToUser) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.advisorsAssignedToUser = advisorsAssignedToUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Advisor> getAdvisorsAssignedToUser() {
		return advisorsAssignedToUser;
	}
	public void setAdvisorsAssignedToUser(List<Advisor> advisorsAssignedToUser) {
		this.advisorsAssignedToUser = advisorsAssignedToUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", advisorsAssignedToUser="
				+ advisorsAssignedToUser + "]";
	}
	
	
	
	 
	 
	 
}
