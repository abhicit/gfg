package com.gfg.dp;

public class LongestCommonSubsequenceMemo {
	static String name1 = "abjanh";
	static String name2 = "abh";
	static int[][] memo = new int[name1.length()+1][name2.length()+1];
	public static void main(String[] args) {
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[i].length; j++) {
				memo[i][j] = -1;
			}
		}
		System.out.println(lcs(name1, name2, 0, 0));
	}

	private static int lcs(String str1, String str2, int m, int n) {
		if(memo[m][n] == -1) {
			int res;
			if(m == str1.length() || n == str2.length()) {
				memo[m][n] = 0;
				return memo[m][n];
			}
			if(str1.charAt(m) == str2.charAt(n))
				memo[m][n] = 1+lcs(str1, str2, m+1, n+1);
			else
				memo[m][n] = Math.max(lcs(str1, str2, m+1, n), lcs(str1, str2, m, n+1));
		}
		return memo[m][n];
	}
}
