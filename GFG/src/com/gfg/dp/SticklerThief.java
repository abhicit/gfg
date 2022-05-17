package com.gfg.dp;

import java.util.Arrays;

public class SticklerThief {
	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10, 5};
		int[] dp = new int[arr.length+1];
		Arrays.fill(dp, -1);
		System.out.println(maxProfit(arr, arr.length-1, dp));
	}

	private static int maxProfit(int[] arr, int n, int[] dp) {
		if(n <= -1)
			return 0;
		if(dp[n] != -1)
			return dp[n];
		return dp[n] = Math.max(arr[n]+maxProfit(arr, n-2, dp), maxProfit(arr, n-1, dp));
	}
}
