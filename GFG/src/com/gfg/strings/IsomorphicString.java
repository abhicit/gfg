package com.gfg.strings;

import java.util.Arrays;

public class IsomorphicString {
	public static boolean isIsomorphic(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		boolean[] visited = new boolean[256];
		Arrays.fill(visited, false);
		
		int[] map = new int[256];
		Arrays.fill(map, -1);
		
		for(int i = 0; i < str1.length(); i++) {
			if(map[str1.charAt(i)] == -1) {
				if(visited[str2.charAt(i)] == true)
					return false;
				visited[str2.charAt(i)] = true;
				map[str1.charAt(i)] = str2.charAt(i);
			}else {
				if(map[str1.charAt(i)] != str2.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "abb";
		String str2 = "xyz";
		System.out.println(isIsomorphic(str1, str2));
	}
}
