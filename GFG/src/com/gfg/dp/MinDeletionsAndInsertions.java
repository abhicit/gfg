package com.gfg.dp;

public class MinDeletionsAndInsertions {
	static String str1 = "abcd";
	static String str2 = "ajfjhjbcf";
	static int[][] memo = new int[str1.length()+1][str2.length()+1];
	public static void main(String[] args) {
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[0].length; j++) {
				memo[i][j] = -1;
			}
		}
		int res = mdi(str1, str2, 0, 0);
		System.out.println("Number of deletions : "+(str1.length()-res));
		System.out.println("Number of insertions : "+(str2.length()-res));
	}
	private static int mdi(String str1, String str2, int m, int n) {
		if(memo[m][n] != -1)
			return memo[m][n];
		if(str1.length() == m || str2.length() == n)
			return 0;
		if(str1.charAt(m) == str2.charAt(n))
			memo[m][n] = 1+mdi(str1, str2, m+1, n+1);
		else
			memo[m][n] = Math.max(mdi(str1, str2, m+1, n), mdi(str1, str2, m, n+1));
		return memo[m][n];
	}
}
