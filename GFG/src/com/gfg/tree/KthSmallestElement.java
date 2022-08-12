package com.gfg.tree;

class TreeNode1{
	TreeNode1 left;
	TreeNode1 right;
	int data;
	int lcount;
	TreeNode1(int data){
		this.data = data;
	}
}

public class KthSmallestElement {
	public static void main(String[] args) {
		TreeNode1 root = insert(null, 10);
		insert(root, 5);
		insert(root, 15);
		insert(root, 12);
		insert(root, 30);
		
		System.out.println(kthSmallest(root, 3).data);
		
		inorder(root);
	}
	
	private static TreeNode1 kthSmallest(TreeNode1 root, int k) {
		if(root == null)
			return null;
		int count = root.lcount+1;
		if(count == k)
			return root;
		if(count > k)
			return kthSmallest(root.left, k);
		return kthSmallest(root.right, k-count);
	}

	private static void inorder(TreeNode1 root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root.data+" -> "+root.lcount);
			inorder(root.right);
		}
	}

	public static TreeNode1 insert(TreeNode1 root, int x) {
		if(root == null)
			return new TreeNode1(x);
		TreeNode1 parent = null;
		while(root != null) {
			parent = root;
			if(root.data > x) {
				root.lcount += 1;
				root = root.left;
			}else if(root.data < x)
				root = root.right;
			else
				return root;
		}
		
		if(parent.data > x)
			parent.left = new TreeNode1(x);
		else
			parent.right = new TreeNode1(x);
		
		return root;
	}
}
