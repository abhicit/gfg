package com.gfg.tree;

import java.util.ArrayList;

public class ChildSumParent {
	public static void main(String[] args) {
    	Node root = new Node(4);
        root.left = new Node(4);
        //root.right = new Node(3);
        root.left.left = new Node(4);
        //root.left.right = new Node(5);
        //root.right.left = new Node(6);
        //root.right.right = new Node(7);
        
        System.out.println(isSumProperty(root));
	}
	
	public static int isSumProperty(Node root)
    {
        if(root == null)
            return 1;
        if(root.left == null && root.right == null)
            return 1;
        
        int sum = 0;
        if(root.left != null)
        	sum += root.left.data;
        if(root.right != null)
        	sum += root.right.data;
        return (root.data == sum && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) ? 1 : 0;
        
    }
}
