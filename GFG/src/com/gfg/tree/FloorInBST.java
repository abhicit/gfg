package com.gfg.tree;

public class FloorInBST {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right = new Node(30);
		
		System.out.println(findFloor(root, 11).data);
	}

	private static Node findFloor(Node root, int x) {
		if(root == null)
			return null;
		Node floor = null;
		while(root != null) {
			if(x < root.data)
				root = root.left;
			else if(x > root.data) {
				floor = root;
				root = root.right;
			}
			else 
				return root;
		}
		return floor;
	}
}
