package com.gfg.strings;

public class StringSubsequence {
	
	public static boolean isSubsequence(String str1, String str2) {
		int i = 0, j = 0;
		while(i < str1.length() && j < str2.length()) {
			if(str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			}else
				i++;
		}
		return (j == str2.length());
	}
	
	public static boolean isSubsequenceRec(String str1, String str2, int i, int j) {
		if(j == str2.length())
			return true;
		if(i == str1.length())
			return false;
		if(str1.charAt(i) == str2.charAt(j))
			return isSubsequenceRec(str1, str2, ++i, ++j);
		return isSubsequenceRec(str1, str2, ++i, j);
	}
	
	public static void main(String[] args) {
		String str1 = "geeksforgeeks";
		String str2 = "grges";
		System.out.println(isSubsequence(str1, str2));
		System.out.println(isSubsequenceRec(str1, str2, 0, 0));
	}
	
}
