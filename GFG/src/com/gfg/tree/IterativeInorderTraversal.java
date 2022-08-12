package com.gfg.tree;

import java.util.Stack;

public class IterativeInorderTraversal {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
    	root.left=new TreeNode(20);
    	root.right=new TreeNode(30);
    	root.left.left=new TreeNode(40);
    	root.left.right=new TreeNode(50);
    	//root.left.left.left=new TreeNode(60);
	   // root.left.left.left.left=new TreeNode(70);
	    
	    inorder(root);
	}

	private static void inorder(TreeNode node) {
		TreeNode root = node;
		Stack<TreeNode> st = new Stack<>();
		while(root != null || !st.isEmpty()) {
			while(root != null) {
				st.push(root);
				root = root.left;
			}
			root = st.pop();
			System.out.print(root.key+" ");
			root = root.right;
		}
	}
}
