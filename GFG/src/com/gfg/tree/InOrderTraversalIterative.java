package com.gfg.tree;

import java.util.Stack;

public class InOrderTraversalIterative {
	public static void main(String[] args) {
		Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	
    	inorder(root);
	}

	private static void inorder(Node root) {
		if(root == null)
			return;
		Stack<Node> st = new Stack<>();
		Node curr = root;
		while(curr != null || !st.isEmpty()) {
			while(curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			
			curr = st.pop();
			System.out.print(curr.data+" ");
			curr = curr.right;
		}
	}
}
