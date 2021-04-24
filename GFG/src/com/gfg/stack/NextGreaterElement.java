package com.gfg.stack;

import java.util.Stack;

public class NextGreaterElement {
	public static long[] nextLargerElement(long[] arr, int n) { 
        long[] res = new long[n];
        Stack<Long> st = new Stack<>();
        st.push(arr[n-1]);
        res[n-1] = -1;
        
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i])
            	st.pop();
            long nextGreater = (st.isEmpty()) ? -1 : st.peek();
            res[i] = nextGreater;
            st.push(arr[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		long[] arr = {1, 3, 2, 4};
		long[] res = nextLargerElement(arr, arr.length);
		for(long i : res)
			System.out.print(i+" ");
	}
}
