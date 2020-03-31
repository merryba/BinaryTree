package com.merryba.login.service;


import com.merryba.login.model.User;

public interface UserService {
	
	    
		public User findByEmail(String email);
		
		public User findByEmailAndPassword(String email,String password);
		
		public  void saveUser(User user) ;

	}