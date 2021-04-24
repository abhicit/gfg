package com.gfg.stack;

import java.util.Stack;

public class StockSpanProblem {
	public static int[] calculateSpan(int price[], int n)
    {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>(); 
        st.push(0);
        res[0] = 1;
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && price[st.peek()] <= price[i])
                st.pop();
            res[i] = (st.isEmpty()) ? i+1 : i-st.peek();
            st.push(i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		int[] res = calculateSpan(arr, arr.length);
		for(int i : res) {
			System.out.print(i+" ");
		}
	}
}
