package com.gfg.dp;

public class LongestCommonSubsequenceTab {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "asb";
		System.out.println(lcs(str1, str2));
	}

	private static int lcs(String str1, String str2) {
		int m = str1.length(), n = str2.length();
		int[][] tab = new int[m+1][n+1];
		
		for(int i = 0; i < tab.length; i++)
			tab[i][0] = 0;
		for(int i = 0; i < tab[0].length; i++)
			tab[0][i] = 0;
		
		for(int i = 1; i < tab.length; i++) {
			for(int j = 1; j < tab[0].length; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1))
					tab[i][j] = 1 + tab[i-1][j-1];
				else
					tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
			}
		}
		return tab[m][n];
	}
}
