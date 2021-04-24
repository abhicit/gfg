package com.work;

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

 class Node1
 {
     int data;
     Node1 left,right;
     Node1(int data){
     this.data = data;
     left=null;
     right=null;
 }
 }
		
public class Test3
{
 static Node1 buildTree(String str){
     
     if(str.length()==0 || str.charAt(0)=='N'){
         return null;
     }
     
     String ip[] = str.split(" ");
     // Create the root of the tree
     Node1 root = new Node1(Integer.parseInt(ip[0]));
     // Push the root to the queue
     
     Queue<Node1> queue = new LinkedList<>(); 
     
     queue.add(root);
     // Starting from the second element
     
     int i = 1;
     while(queue.size()>0 && i < ip.length) {
         
         // Get and remove the front of the queue
         Node1 currNode1 = queue.peek();
         queue.remove();
             
         // Get the current Node1's value from the string
         String currVal = ip[i];
             
         // If the left child is not null
         if(!currVal.equals("N")) {
                 
             // Create the left child for the current Node1
             currNode1.left = new Node1(Integer.parseInt(currVal));
             // Push it to the queue
             queue.add(currNode1.left);
         }
             
         // For the right child
         i++;
         if(i >= ip.length)
             break;
             
         currVal = ip[i];
             
         // If the right child is not null
         if(!currVal.equals("N")) {
                 
             // Create the right child for the current Node1
             currNode1.right = new Node1(Integer.parseInt(currVal));
                 
             // Push it to the queue
             queue.add(currNode1.right);
         }
         i++;
     }
     
     return root;
 }
 
	public static void inorder(Node1 root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
  /* Drier program to test above functions */
 public static void main(String args[]) throws IOException
 {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
 
	        while(t > 0){
	            String s = br.readLine();
 	    	Node1 root = buildTree("7 9 7 8 8 6 N 10 9");
     	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
 			
             t--;
         
     }
	}
}// } Driver Code Ends


//User function Template for Java

/*class Node1
{
 int data;
 Node1 left,right;
 Node1(int d)
 {
     data=d;
     left=right=null;
 }
}*/
//Print the zig zag traversal of tree.
class GFG
{
 // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node1 root)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	    if(root == null)
	        return res;
	    Stack<Node1> st1 = new Stack<>();
	    Stack<Node1> st2 = new Stack<>();
	    st1.push(root);
	    boolean flag = true;
	    while(!st1.isEmpty() || !st2.isEmpty()){
	        if(flag){
	            int count = st1.size();
	            for(int i = 0; i < count; i++){
	                Node1 temp = st1.pop();
	                res.add(temp.data);
	                if(temp.left != null)
	                    st2.push(temp.left);
	                if(temp.right != null)
	                    st2.push(temp.right);
	            }
	            flag = false;
	        }else{
	            int count = st2.size();
	            for(int i = 0; i < count; i++){
	                Node1 temp = st2.pop();
	                res.add(temp.data);
	                if(temp.right != null)
	                    st1.push(temp.right);
	                if(temp.left != null)
	                    st1.push(temp.left);
	            }
	            flag = true;
	        }
	    }
	    
	    return res;
	}
}