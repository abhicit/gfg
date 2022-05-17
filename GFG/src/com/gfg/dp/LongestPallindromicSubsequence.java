package com.gfg.dp;

public class LongestPallindromicSubsequence {
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		System.out.println(longestPallindromicSubsequence(str));
	}

	private static int longestPallindromicSubsequence(String str) {
		StringBuffer sb = new StringBuffer(str);
		return util(str, sb.reverse().toString());
	}

	private static int util(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[m][n];
	}
}
