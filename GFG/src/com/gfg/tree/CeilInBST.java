package com.gfg.tree;

public class CeilInBST {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right = new Node(30);
		
		System.out.println(findCeil(root, 6).data);
	}

	private static Node findCeil(Node root, int x) {
		if(root == null)
			return null;
		Node ceil = null;
		while(root != null) {
			if(x > root.data)
				root = root.right;
			else if(x < root.data) {
				ceil = root;
				root = root.left;
			}else
				return root;
		}
		return ceil;
	}
}
