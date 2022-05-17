package com.gfg.dp;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 8, 10, 15};
		System.out.println(lis(arr, arr.length));
	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		lis[0] = 1;
		
		for(int i = 1; i < n; i++) {
			lis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					lis[i] = Math.max(lis[j]+1, lis[i]);
			}
		}
		
		int res = 0;
		for(int i : lis)
			res = Math.max(res, i);
		
		return res;
	}
}
