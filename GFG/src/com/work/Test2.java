package com.work;

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;



class Test2 {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = "9 8 11 4 N 10 12 3 7 N N N N 2 N 6 N 1 N 5 N 0 N N N N N";
    	    	Node root = buildTree(s);
                Spiral g = new Spiral();
                ArrayList<Integer> result = g.findSpiral(root);
                for(int value : result)
                System.out.print(value + " ");
			    System.out.println();
    	        
	        }
	}
}



// } Driver Code Ends


//User function Template for Java


/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Spiral
{
      ArrayList<Integer> findSpiral(Node root) 
      {
           ArrayList<Integer> res = new ArrayList<>();
           Stack<Node> s = new Stack<>();
           Stack<Node> st = new Stack<>();
           if(root == null)
                return res;
           boolean flag = true;
           st.push(root);
           while(true){
               if(st.isEmpty() && s.isEmpty())
                    break;
               if(flag){
                   int count = st.size();
                   for(int i = 0; i < count; i++){
                       Node curr = st.pop();
                       res.add(curr.data);
                       if(curr.left != null)
                            s.push(curr.left);
                        if(curr.right != null)
                            s.push(curr.right);
                   }
                   flag = false;
               }else{
                   int count = s.size();
                   for(int i = 0; i < count; i++){
                       Node curr = s.pop();
                       res.add(curr.data);
                       if(curr.left != null)
                            st.push(curr.left);
                        if(curr.right != null)
                            st.push(curr.right);
                   }
                   flag = true;
               }
               
           }
           return res;
      }
      
}