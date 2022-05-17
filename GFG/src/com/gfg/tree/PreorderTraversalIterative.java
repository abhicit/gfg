package com.gfg.tree;

import java.util.Stack;

public class PreorderTraversalIterative {
	public static void main(String[] args) {
		Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(5);
    	root.left.right=new Node(9);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	
    	preorder(root);
	}

	private static void preorder(Node root) {
		Stack<Node> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			Node curr = st.pop();
			System.out.print(curr.data+" ");
			if(curr.right != null)
				st.push(curr.right);
			if(curr.left != null)
				st.push(curr.left);
		}
	}
}
