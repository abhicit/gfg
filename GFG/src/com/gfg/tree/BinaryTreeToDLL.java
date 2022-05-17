package com.gfg.tree;

public class BinaryTreeToDLL {
	static TreeNode prev = null;
	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
    	root.left=new TreeNode(5);
    	root.right=new TreeNode(20);
    	root.right.left=new TreeNode(30);
    	root.right.right=new TreeNode(35);
    	
    	TreeNode head = btToDll(root);
    	TreeNode curr = head;
    	while(curr != null) {
    		System.out.print(curr.key+" ");
    		curr = curr.right;
    	}
	}

	private static TreeNode btToDll(TreeNode root) {
		if(root == null)
			return root;
		
		TreeNode head = btToDll(root.left);
		if(prev == null) {
			head = root;
		}else {
			root.left = prev;
			prev.right = root;
		}
		
		prev = root;
		btToDll(root.right);
		return head;
	}
}
