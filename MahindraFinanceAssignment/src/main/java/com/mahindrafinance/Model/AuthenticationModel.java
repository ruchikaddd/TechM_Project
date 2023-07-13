package com.mahindrafinance.Model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AuthenticationModel {
	 private String token;
	 private String userId;
	 
	public AuthenticationModel(String token, String userId) {
		super();
		this.token = token;
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	 
	 
	 
}
