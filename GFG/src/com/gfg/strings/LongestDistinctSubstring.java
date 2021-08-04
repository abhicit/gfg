package com.gfg.strings;

import java.util.Arrays;

public class LongestDistinctSubstring {
	public static void main(String[] args) {
		String str = "kaskedin"; //window sliding
		System.out.println(longestDistinctSubstring(str));
	}
	
	public static String longestDistinctSubstring(String s) {//O(n^2)
		
		int res = 0, max = 0;
		String str = "";
		
		for(int i = 0; i < s.length(); i++) {//n times
			Boolean[] bool = new Boolean[256];
			Arrays.fill(bool, false);
			for(int j = i; j < s.length(); j++) {//n times
				if(bool[s.charAt(j)])
					break;
				else {
					res = Math.max(res, j - i + 1);
					bool[s.charAt(j)] = true;
					if(max < res) {
						max = res;
						str = s.substring(i, j+1);
					}
				}
			}
			bool[s.charAt(i)] = false;
		}
		return str;
	}
}
