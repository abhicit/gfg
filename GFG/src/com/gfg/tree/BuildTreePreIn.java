package com.gfg.tree;

public class BuildTreePreIn {
	public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return util(inorder, preorder, 0, n-1, 0);
    }
    
    public static Node util(int[] inorder, int[] preorder, int start, int end, int index){
        if(start > end)
            return null;
            
        if(index == end)
            return null;
        
        Node root = new Node(preorder[index]);
        
        int inIndex = 0;
        
        for(int i = start; i <= end; i++){
            if(root.data == inorder[i]){
                inIndex = i;
                index = index + 1;
                break;
            }
        }
        
        root.left = util(inorder, preorder, start, inIndex-1, index);
        root.right = util(inorder, preorder, inIndex+1, end, index);
        
        return root;
    }
    
    public static void main(String[] args) {
		int[] inorder = {10, 1, 30, 40, 20};
		int[] preorder = {1, 10, 20, 30, 40};
		
		Node root = buildTree(inorder, preorder, inorder.length);
		
		System.out.println(root.data);
	}
}
