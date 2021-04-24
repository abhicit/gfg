package com.gfg.stack;

import java.util.Stack;

public class CelebrityProblem {
	static int celebrity(int M[][], int n){
    	Stack<Integer> st = new Stack<>();
    	int res = 0;
    	for(int i = 0; i < n; i++)
    	    st.push(i);
    	while(st.size() > 1){
    	    int a = st.pop();
    	    int b = st.pop();
    	    
    	    if(M[a][b] == 1)
    	        st.push(b);
    	    else
    	        st.push(a);
    	}
    	
    	if(st.isEmpty())
    	    return -1;
    	
    	int c = st.pop();
    	
    	for(int i = 0; i < n; i++){
    	    if(i != c && (M[c][i] == 1 || M[i][c] != 1))
    	        return -1;
    	}
    	return c;
    }
	
	public static void main(String[] args) {
		int[][] M = {{0, 1, 0},
		         {0, 0, 0}, 
		         {0, 1, 0}};
		System.out.println(celebrity(M, M.length));
	}
}
