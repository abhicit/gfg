package com.gfg.tree;

import java.util.Stack;

public class PostOrderTraversalIterative {
	public static void main(String[] args) {
		Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.left=new Node(60);
    	root.right.right=new Node(70);
    	postOrder(root);
	}

	private static void postOrder(Node root) {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.push(root);
		while(!st1.isEmpty()) {
			Node curr = st1.pop();
			st2.push(curr);
			if(curr.left != null)
				st1.push(curr.left);
			if(curr.right != null)
				st1.push(curr.right);
		}
		
		while(!st2.isEmpty())
			System.out.print(st2.pop().data+" ");
		
		
	}
}
