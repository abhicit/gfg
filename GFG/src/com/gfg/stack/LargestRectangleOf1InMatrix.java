package com.gfg.stack;

import java.util.Stack;

public class LargestRectangleOf1InMatrix {
	public static void main(String[] args) {
		int[][] arr = {{1, 1, 1, 1, 1},
					   {0, 1, 1, 1, 1},
					   {1, 1, 1, 1, 1},
					   {0, 1, 1, 1, 1}};
		System.out.println(maxRectangle(arr));
	}

	private static int maxRectangle(int[][] arr) {
		int res = getMaxArea(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 1)
					arr[i][j] += arr[i-1][j];
			}
			res = Math.max(res, getMaxArea(arr[i]));
		}
		return res;
	}
	
	private static int getMaxArea(int[] arr) {
		Stack<Integer> st = new Stack<>();
		int maxArea = 0;
		int top = 0;
		int areaWithTop = 0;
		int i = 0;
		
		while(i < arr.length) {
			if(st.empty() || st.peek() <= arr[i])
				st.push(i++);
			else {
				top = st.pop();
				areaWithTop = arr[top] * ((st.isEmpty()) ? i : i - st.peek() - 1);
				maxArea = Math.max(maxArea, areaWithTop);
			}
		}
		
		while(!st.isEmpty()) {
			top = st.pop();
			areaWithTop = arr[top] * ((st.isEmpty()) ? i : i - st.peek() - 1);
			maxArea = Math.max(maxArea, areaWithTop);
		}
		return maxArea;
	}
}
