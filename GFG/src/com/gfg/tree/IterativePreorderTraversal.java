package com.gfg.tree;

import java.util.Stack;

public class IterativePreorderTraversal {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
    	root.left=new TreeNode(20);
    	root.right=new TreeNode(30);
    	root.left.left=new TreeNode(40);
    	root.left.right=new TreeNode(50);
    	//root.left.left.left=new TreeNode(60);
	   // root.left.left.left.left=new TreeNode(70);
	    
	    preorder(root);
	}

	private static void preorder(TreeNode node) {
		TreeNode root = node;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode curr = st.pop();
			System.out.print(curr.key+" ");
			if(curr.right != null)
				st.push(curr.right);
			if(curr.left != null)
				st.push(curr.left);
		}
		
	}
}
