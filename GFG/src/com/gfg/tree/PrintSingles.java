package com.gfg.tree;

public class PrintSingles {
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        
        printSingle(root);
	}

	private static void printSingle(Node root) {
		if(root == null)
			return;
		if(root.left != null && root.right != null) {
			printSingle(root.left);
			printSingle(root.right);
		}
		
		else if(root.left != null) {
			System.out.println(root.left.data);
			printSingle(root.left);
		}
		
		else if(root.right != null) {
			System.out.println(root.right.data);
			printSingle(root.right);
		}
		
	}
}
