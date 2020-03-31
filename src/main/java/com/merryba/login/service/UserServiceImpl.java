package com.merryba.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.merryba.login.model.User;
import com.merryba.login.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
    @Autowired
    public UserServiceImpl(UserRepository userRepository) { 
    	this.userRepository = userRepository;
    }
    @Override
	public User findByEmail(String email) {
    	return userRepository.findByEmail(email);
	}
    
    
   	public User findByEmailAndPassword(String email,String password) {
       	return userRepository.findByEmailAndPassword(email,password);
   	}
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}