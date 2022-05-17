package com.gfg.dp;

import java.util.Arrays;

public class ShortestCommonSupersequence {
	public static void main(String[] args) {
		String s1 = "GEEK";
		String s2 = "EKE";
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int[] i : dp)
			Arrays.fill(i, -1);
		int lcs = scsLength(s1, s2, s1.length(), s2.length(), dp);
		System.out.println("Shortest Common Supersequence Length : "+(lcs+(s1.length()-lcs)+(s2.length()-lcs)));
		
	}

	private static int scsLength(String s1, String s2, int m, int n, int[][] dp) {
		
		if(m == 0 || n == 0)
			return dp[m][n] = 0;
		if(dp[m][n] != -1)
			return dp[m][n];
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			dp[m][n] = 1+scsLength(s1, s2, m-1, n-1, dp);
		}
		else {
			dp[m][n] = Math.max(scsLength(s1, s2, m, n-1, dp), scsLength(s1, s2, m-1, n, dp));
		}
		return dp[m][n];
	}
}
