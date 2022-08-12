package com.gfg.tree;

public class BSTSearchInsertDelete {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right = new Node(18);
		
		System.out.println(search(root, 1));
		root = insert(root, 4);
		inorder(root);
		root = delete(root, 10);
		System.out.println();
		inorder(root);
	}

	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	private static Node insert(Node root, int x) {
		if(root == null) {
			root = new Node(x);
			return root;
		}
		if(root.data > x)
			root.left = insert(root.left, x);
		else if(root.data < x)
			root.right = insert(root.right, x);
		return root;
	}

	private static boolean search(Node root, int x) {
		if(root == null)
			return false;
		if(root.data == x)
			return true;
		if(root.data > x)
			return search(root.left, x);
		return search(root.right, x);
	}
	
	private static Node delete(Node root, int x) {
		if(root == null)
			return null;
		if(x > root.data)
			root.right = delete(root.right, x);
		else if(x < root.data)
			root.left = delete(root.left, x);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node succ = inorderSuccessor(root);
				root.data = succ.data;
				root.right = delete(root.right, succ.data);
			}
		}
		return root;
	}
	
	private static Node inorderSuccessor(Node root) {
		Node curr = root.right;
		while(curr != null && curr.left != null) {
			curr = curr.left;
		}
		
		return curr;
	}
}
