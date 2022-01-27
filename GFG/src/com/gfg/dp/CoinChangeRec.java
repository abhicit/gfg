package com.gfg.dp;

import java.util.Arrays;

public class CoinChangeRec {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		int sum = 1000;
		long start = System.currentTimeMillis();
		int res = getCount(arr, arr.length, sum);
		long end = System.currentTimeMillis();
		System.out.println(res+" "+(end-start));
		int[][] dp = new int[arr.length+1][sum+1];
		for(int i = 0; i <= arr.length; i++)
			Arrays.fill(dp[i], -1);
		System.out.println();
		long start1 = System.currentTimeMillis();
		int res1 = getCountMemo(arr, arr.length, sum, dp);
		long end1 = System.currentTimeMillis();
		System.out.println(res1+" "+(end1-start1));
	}

	private static int getCount(int[] arr, int n, int sum) {
		if(sum == 0)
			return 1;
		if(sum < 0)
			return 0;
		if(n <= 0 && sum >= 1)
			return 0;
		return getCount(arr, n-1, sum) + getCount(arr, n, sum-arr[n-1]);
	}
	
	public static int getCountMemo(int[] arr, int n, int sum, int[][] dp) {
		if(sum == 0)
			return dp[n][sum] = 1;
		if(n == 0)
			return 0;
		if(dp[n][sum] != -1)
			return dp[n][sum];
		if(arr[n-1] <= sum) {
			return dp[n][sum] = getCountMemo(arr, n, sum-arr[n-1], dp) 
					+ getCountMemo(arr, n-1, sum, dp);
		}else {
			return dp[n][sum] = getCountMemo(arr, n-1, sum, dp);
		}
	}
	
}
