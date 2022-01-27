package com.gfg.stack;

import java.util.Stack;

public class PreviousGreaterElement {
	public static void main(String[] args) {
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		int[] res = prevGreater(arr, arr.length);
		for(int i : res) {
			System.out.print(i+" ");
		}
	}

	private static int[] prevGreater(int[] arr, int length) {
		int[] res = new int[length];
		Stack<Integer> st = new Stack<>();
		res[0] = -1;
		st.push(arr[0]);
		
		for(int i = 1; i < length; i++) {
			while(!st.isEmpty() && st.peek() <= arr[i])
				st.pop();
			res[i] = (st.isEmpty()) ? -1 : st.peek();
			st.push(arr[i]);
		}
		
		return res;
	}
}
