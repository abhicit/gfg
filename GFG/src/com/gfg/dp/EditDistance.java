package com.gfg.dp;

public class EditDistance {
	public static void main(String[] args) {
		String s1 = "ABHISHEK";
		String s2 = "ABHINAV";
		System.out.println(count(s1, s2, s1.length(), s2.length()));
		System.out.println();
		System.out.println(countTab(s1, s2, s1.length(), s2.length()));
	}

	private static int count(String s1, String s2, int m, int n) {
		if(n == 0) return m;
		if(m == 0) return n;
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return count(s1, s2, m-1, n-1);
		else {
			return 1+Math.min(count(s1, s2, m, n-1), 
					Math.min(count(s1, s2, m-1, n), count(s1, s2, m-1, n-1)));
		}
	}
	
	private static int countTab(String s1, String s2, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		if(m == 0) return n;
		if(n == 0) return m;
		
		for(int i = 0; i < dp.length; i++)
			dp[i][0] = i;
		for(int j = 0; j < dp[0].length; j++)
			dp[0][j] = j;
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		
		return dp[m][n];
	}
}
