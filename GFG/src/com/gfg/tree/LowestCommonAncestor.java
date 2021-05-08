package com.gfg.tree;

import java.util.ArrayList;

class Node  
{ 
  int data; 
  Node left; 
  Node right; 
  Node(int data){
      this.data=data;
      left=right=null;
  }
}

public class LowestCommonAncestor {
	
	public static Node findLCAEfficient(Node root, int n1, int n2) {//Theta(n)
		if(root == null)
			return null;
		if(root.data == n1 || root.data == n2)
			return root;
		Node lca1 = findLCAEfficient(root.left, n1, n2);
		Node lca2 = findLCAEfficient(root.right, n1, n2);
		
		if(lca1 != null && lca2 != null)
			return root;
		if(lca1 != null)
			return lca1;
		else
			return lca2;
	}
	
	public static Node findLCA(Node root, int n1, int n2) {
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		
		if(!findPath(root, path1, n1) || !findPath(root, path2, n2))
			return null;
		for(int i = 0; i < path1.size()-1 && i < path2.size()-1; i++)//O(n)
			if(path1.get(i+1) != path2.get(i+1))
				return path1.get(i);
		return null;
	}
	
	public static boolean findPath(Node root, ArrayList<Node> path, int n) {//Theta(n)
		if(root == null)
			return false;
		
		path.add(root);
		
		if(root.data == n)
			return true;
		
		if(findPath(root.left, path, n) || findPath(root.right, path, n))
			return true;
		
		path.remove(path.size()-1);
		return false;
	}
	
	public static void main(String args[]) 
    { 
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
    	int n1=20,n2=50;
	
	    //Node ans=findLCA(root,n1,n2);
	    Node ans=findLCAEfficient(root,n1,n2);
    	System.out.println("LCA: "+ans.data);
    } 
	
}
