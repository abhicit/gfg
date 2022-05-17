package com.gfg.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinNode {
	public static boolean isCousins(Node root, int a, int b) {
        int aLevel = -1;
        int bLevel = -2;
        Node aParent = null;
        Node bParent = null;
        int level = 0;
        
        if(root.data == a || root.data == b)
        	return false;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
            	Node temp = q.poll();
            	if(temp.left != null && (temp.left.data == a || temp.left.data == b)) {
            		aParent = temp;
            		aLevel = level+1;
            	}
            	if(temp.right != null && (temp.right.data == b || temp.right.data == a)) {
            		bParent = temp;
            		bLevel = level+1;
            	}
            	
            	if(aParent != null && bParent != null)
            		break;
            	
            	if(temp.left != null)
            		q.add(temp.left);
            	
            	if(temp.right != null)
            		q.add(temp.right);
            }
            
            if(aParent != bParent && aLevel == bLevel)
            	return true;
            
            level++;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //root.left.left = new Node(5);
        //root.right.right = new Node(4);
        
        System.out.println(isCousins(root, 5, 4));
	}
}
