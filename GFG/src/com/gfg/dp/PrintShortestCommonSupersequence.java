package com.gfg.dp;

public class PrintShortestCommonSupersequence {
	public static void main(String[] args) {
		String X = "AGGTAB";
        String Y = "GXTXAYB";
        StringBuilder sb = new StringBuilder(printShortestSuperSeq(X, Y));
        System.out.println(sb.reverse());
	}

	private static String printShortestSuperSeq(String x, String y) {
		int m = x.length();
		int n = y.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}
		String str = "";
		
		int i = m, j = n;
		
		while(i > 0 && j > 0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				str += x.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				str += x.charAt(i-1);
				i--;
			}else {
				str += y.charAt(j-1);
				j--;
			}
		}
		
		while(i > 0) {
			str += x.charAt(i-1);
			i--;
		}
		
		while(j > 0) {
			str += y.charAt(j-1);
			j--;
		}
		
		return str;
	}
}
