package com.mahindrafinance.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahindrafinance.Model.Advisor;
import com.mahindrafinance.Model.AuthenticationModel;
import com.mahindrafinance.Model.User;
import com.mahindrafinance.authentication.AuthenticationService;
import com.mahindrafinance.service.UserService;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationService authenticationService;
  
    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody User request) {
        if (request.getName() == null || request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("One or more fields are missing.");
        }
        
        String token = authenticationService.generateToken();
        String userId = userService.createUser(request);

        AuthenticationModel response = new AuthenticationModel(token, userId);

        return ResponseEntity.ok(response);
    }
    
    
    @PostMapping("/user/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        if (user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("One or more fields are missing.");
        }

        // Check the email/password combination against authentication service
        boolean isValidCredentials = authenticationService.authenticateUser(user.getEmail(), user.getPassword());

        if (isValidCredentials) {
            String token = authenticationService.generateToken();
            String userId = userService.retrieveUserId(user.getEmail());

            AuthenticationModel response = new AuthenticationModel(token, userId);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed. Invalid email/password combination.");
        }
    }
    

    
}

