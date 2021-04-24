package com.work;

class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

public class Test1 {
	public static int isSumProperty(Node root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
        return (root.data == isSumProperty(root.left) + isSumProperty(root.right)) ? 1 : 0;
    }
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(10);
		root.left.left = new Node(10);
		System.out.println(isSumProperty(root));
	}
}
