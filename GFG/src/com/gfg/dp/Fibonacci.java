package com.gfg.dp;

import java.util.Arrays;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		for(int i = 0; i <= n; i++) {
			System.out.print(fib(i, dp)+" ");
		}
		System.out.println();
		int[] res = fib(n);
		for(int i : res)
			System.out.print(i+" ");
		
	}

	private static int fib(int n, int[] dp) {
		if(dp[n] == -1) {
			int res;
			if(n == 0 || n == 1) 
				res = n;
			else
				res = fib(n-1, dp) + fib(n-2, dp);
			dp[n] = res;
		}
		return dp[n];
	} 
	
	private static int[] fib(int n) {
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			fib[i] = fib[i-2] + fib[i-1];
		}
		
		return fib;
	}
	
}
