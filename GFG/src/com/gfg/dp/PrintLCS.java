package com.gfg.dp;

public class PrintLCS {
	public static void main(String[] args) {
		String s1 = "GEEK";
		String s2 = "GEFK";
		int m = s1.length();
		int n = s2.length();
		
		int[][] lookup = new int[m+1][n+1];
		
		LCSLength(s1, s2, m, n, lookup);
		
		System.out.println(LCS(s1, s2, m, n, lookup));
		
		printLCS(s1, s2, m, n);
		
	}

	private static String LCS(String s1, String s2, int m, int n, int[][] lookup) {
		if(m == 0 || n == 0)
			return new String();
		
		if(s1.charAt(m-1) == s2.charAt(n-1))
			return LCS(s1, s2, m-1, n-1, lookup) + s1.charAt(m-1);
		if(lookup[m-1][n] > lookup[m][n-1])
			return LCS(s1, s2, m-1, n, lookup);
		else
			return LCS(s1, s2, m, n-1, lookup);
	}

	private static void LCSLength(String s1, String s2, int m, int n, int[][] lookup) {
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					lookup[i][j] = lookup[i-1][j-1] + 1;
				else
					lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
			}
		}
	}
	
	private static void printLCS(String s1, String s2, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		int index = dp[m][n];
		int temp = index;
		
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000';
		
		int i = m;
		int j = n;
		
		while(i > 0 && j > 0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs[index-1] = s1.charAt(i-1);
				i--;
				j--;
				index--;
			}else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.print("LCS of "+s1+" and "+s2+" is : ");
		for(char c : lcs)
			System.out.print(c);
	}
}
