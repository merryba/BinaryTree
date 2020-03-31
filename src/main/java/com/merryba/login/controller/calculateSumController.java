package com.merryba.login.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.merryba.login.service.BinaryTreeService;
import com.merryba.login.model.User;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@Scope("request")
public class calculateSumController {
	@Autowired
	BinaryTreeService binarytree;
	
	 private static final Logger logger = LoggerFactory.getLogger(calculateSumController.class);


	   
	
	 	@CrossOrigin
	    @RequestMapping(value="/sum",method=RequestMethod.POST)
	    public  ResponseEntity<?> MaxSumBinaryTree(@RequestBody int[] values) {
	    	 HashMap<String, Object> response = new HashMap<>();
	    	 
	    	 			int sum = binarytree.getMaxSum(values);
	    	 			response.put("sums",sum );
	                    
	    	 			logger.info("sums"+sum);
	    	 			return new ResponseEntity<>(sum,HttpStatus.OK);
		}
	 
	
	
}