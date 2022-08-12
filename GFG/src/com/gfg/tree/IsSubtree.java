package com.gfg.tree;

public class IsSubtree {
	static boolean res = false;
	
	public static void main(String[] args) {
		Node T = new Node(10);
		T.left = new Node(4);
		T.right = new Node(6);
		//T.left.left = new Node(4);
		T.left.right = new Node(30);
		T.right.left = new Node(2);
		//T.left.right.right = new Node(25);
		
		Node S = new Node(10);
		S.left = new Node(4);
		S.right = new Node(6);
		S.left.right = new Node(30);
		
		System.out.println(isSubtree(T, S));
	}
	
    public static boolean isSubtree(Node T, Node S) {
        if(T.data != S.data)
            inorder(T, S);
        else
            util(T, S);
        return res;
    }
    
    public static void inorder(Node T, Node S){
        if(T != null){
            inorder(T.left, S);
            if(T.data == S.data){
                Node temp = T;
                util(temp, S);
                return;
            }
            inorder(T.right, S);
        }
    }
    
    public static void util(Node T, Node S){
    	if(T == null && S != null) {
    		res = false;
    		return;
    	}
    	else if(T != null && S == null) {
    		res = false;
    		return;
    	}
    	else if(T != null && S != null){
            util(T.left, S.left);
            if(T.data != S.data){
                res = false;
                return;
            }else
                res = true;
            util(T.right, S.right);
        }
    }
}
