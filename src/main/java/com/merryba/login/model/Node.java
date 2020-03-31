package com.merryba.login.model;

public class Node {
	public int data; 
    public Node left;
	public Node right; 
	public Node (){}
  
    public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
    
    public void addNode(int num) {
    	
    	
		if (num < this.data) {
			if (this.left != null) {
				this.left.addNode(num);
			} else {
				this.left = new Node(num);
			}

		} else {
			if (this.right != null) {
				this.right.addNode(num);
			} else {
				this.right = new Node(num);
			}

			}
		}
    
    
    public Node insertLevelOrder(int[] arr, Node root, int i) { 

    		if (i < arr.length) { 
    			Node temp = new Node(arr[i]); 
    			root = temp; 

    			// insert left child 
    			root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 

    			// insert right child 
    			root.right = insertLevelOrder(arr, root.right,2 * i + 2); 
    		} 
    		return root; 
    } 
}
