package com.gfg.dp;

public class MCM {
	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10, 30};
		System.out.println(cost(arr, 1, arr.length-1));
	}

	private static int cost(int[] arr, int i, int j) {
		if(i >= j)
			return 0;
		int res = Integer.MAX_VALUE;
		
		for(int k = i; k < j; k++) {
			int min = cost(arr, i, k) + cost(arr, k+1, j) + 
					arr[i]*arr[j]*arr[k];
			res = Math.min(res, min);
		}
		return res;
	}
}
