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
		printScs(s1, s2, s1.length(), s2.length());
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
	
	public static void printScs(String s1, String s2, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0) 
					dp[i][j] = j;
				else if(j == 0)
					dp[i][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		String str = "";
		int i = m, j = n;
		while(i > 0 && j > 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				str += (s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) {
				str += (s2.charAt(j-1));
				j--;
			}
			else {
				str += (s1.charAt(i-1));
				i--;
			}
		}
		
		while(i > 0) {
			str += (s1.charAt(i-1));
			i--;
		}
		
		while(j > 0) {
			str += (s2.charAt(j-1));
			j--;
		}
		
		for(int c = str.length()-1; c >= 0; c--)
			System.out.print(str.charAt(c));
	}
}
