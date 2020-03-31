package com.merryba.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import com.merryba.login.repository.UserRepository;
import com.merryba.login.model.User;
import static java.util.Collections.emptyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/auth")
@CrossOrigin
@Scope("request")
public class LoginController {

   
    @Autowired
    UserRepository userRepository;
    
    
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


   

    
    @CrossOrigin
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody User user) {
    	 
    	 String email = user.getEmail();
    	 String password = bCryptPasswordEncoder.encode(user.getPassword());
        
        if( email != null && password != null) {
           
                User applicationUser = userRepository.findByEmail(email);
                if (applicationUser == null) {
                    applicationUser = new User();
                    applicationUser.setPassword(password);
                    applicationUser.setEmail(email);
                    User createdApplicationUser = userRepository.save(applicationUser);
                    if(createdApplicationUser != null) {
                    	return new ResponseEntity<>( HttpStatus.OK);
                    } 
                } else return new ResponseEntity<>(HttpStatus.CONFLICT);
            
        }return new ResponseEntity<>(HttpStatus.CONFLICT);
		
        
    }
    @CrossOrigin
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity<?> loginM(@RequestBody User user) {
    	 
    	String email = user.getEmail();
   	    String password = user.getPassword();
   
    	User isValidUser = userRepository.findByEmail(email);
    	if(isValidUser ==null)
    		{
    		
    		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    		}
    	else { 
    			
    			if(bCryptPasswordEncoder.matches(password,isValidUser.getPassword()))
    				
    				return new ResponseEntity<>( HttpStatus.OK);
    		
    			
    			else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    			
    		}
    }
    
    
 
}