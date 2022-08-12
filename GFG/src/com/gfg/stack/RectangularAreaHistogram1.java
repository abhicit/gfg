package com.gfg.stack;

import java.util.Stack;

public class RectangularAreaHistogram1 {
	public static void main(String[] args) {
		int[] hist = {6,2,5,4,5,1,6};
		System.out.println(getMaxArea(hist, hist.length));
	}
	
	public static int getMaxAreaNaive(int[] hist, int length) {//O(n^2)
		int res = 0;
		for(int i = 0; i < length; i++) {
			int curr = hist[i];
			for(int j = i-1; j >= 0; j--) {
				if(hist[j] >= hist[i])
					curr += hist[i];
				else
					break;
			}
			for(int j = i+1; j < length; j++) {
				if(hist[j] >= hist[i])
					curr += hist[i];
				else
					break;
			}
			
			res = Math.max(res, curr);
		}
		
		return res;
	}

	private static int getMaxArea(int[] hist, int length) {//O(n)
		int[] ns = nextSmaller(hist, length);
		int[] ps = previousSmaller(hist, length);
		int res = 0;
		for(int i = 0; i < length; i++) {
			int curr = hist[i];
			curr += (i - ps[i] - 1)*hist[i];
			curr += (ns[i] - i - 1)*hist[i];
			res = Math.max(res, curr);
		}
		return res;
	}
	
	private static int[] previousSmaller(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		res[0] = -1;
		
		for(int i = 1; i < n; i++) {
			while(!st.isEmpty() && arr[st.peek()] >= arr[i])
				st.pop();
			res[i] = (st.isEmpty()) ? -1 : st.peek();
			st.push(i);
		}
		
		return res;
	}
	
	private static int[] nextSmaller(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(n-1);
		res[n-1] = n;
		
		for(int i = n-2; i >= 0; i--) {
			while(!st.isEmpty() && arr[st.peek()] >= arr[i])
				st.pop();
			res[i] = (st.isEmpty()) ? n : st.peek();
			st.push(i);
		}
		
		return res;
	}
}
