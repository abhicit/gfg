package com.gfg.stack;

import java.util.Stack;

public class RectangularAreaInHistogram {
	public static long getMaxArea(int[] hist, int n) {
		Stack<Integer> st = new Stack<>();
		long maxArea = 0;
		long top = 0;
		long areaWithTop = 0;
		int i = 0;
		while(i < n) {
			if(st.isEmpty() || hist[st.peek()] <= hist[i])
				st.push(i++);
			else {
				top = st.pop();
				areaWithTop = hist[(int) top]*((st.isEmpty()) ? i : i - st.peek() - 1);
				maxArea = Math.max(maxArea, areaWithTop);
			}
		}
		
		while(!st.isEmpty()) {
			top = st.pop();
			areaWithTop = hist[(int) top]*((st.isEmpty()) ? i : i - st.peek() - 1);
			maxArea = Math.max(maxArea, areaWithTop);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] hist = {6,2,5,4,5,1,6};
		System.out.println(getMaxArea(hist, hist.length));
	}
}
