package com.mahindrafinance.authentication;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationService {
	
		String email ="root@gmail.com";
		String password ="root";
	
	public boolean authenticateUser(String userEmail, String userPassword) {
		
		
		if(userEmail.equals(email) && userPassword.equals(password) ) {
			return true;
		}
		return false;
    }
	
	public String generateToken() {
    	String secretKey = "your-secret-key";
        long expirationTime = 3600000; // 1 hour

        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }


}
