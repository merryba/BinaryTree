package com.merryba.login.service;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.merryba.login.model.Node;
@Service
public class BinaryTreeServiceImpl implements BinaryTreeService {
	 int maxSum = Integer.MIN_VALUE;
	
	int currSum = 0;
	
	@Override
	public synchronized int getMaxSum(int[] arr)throws HttpMessageNotReadableException {
		Node root = new Node();
		root = root.insertLevelOrder(arr, root, 0);
		if (root == null) 
            return 0; 
		 calculateMaxSum(root,currSum);
		 return maxSum;
		
	} 
	
	
	
	public synchronized  void calculateMaxSum(Node root, int currSum) {
		if (root == null) 
			return; 
		currSum = currSum + root.data; 

 
 		if (root.left == null && root.right == null) { 
 			maxSum=Math.max(maxSum, currSum);
 		} 

 		calculateMaxSum(root.left,  currSum); 
 		calculateMaxSum(root.right,  currSum); 
	}
	
	

}
