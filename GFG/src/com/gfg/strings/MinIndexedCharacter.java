package com.gfg.strings;

import java.util.Arrays;

public class MinIndexedCharacter {
	public static int minIndexChar(String str, String pat){
        int idx = Integer.MAX_VALUE;
        int[] chars = new int[26];
        Arrays.fill(chars, -1);
        for(int i = 0; i < str.length(); i++){
            if(chars[str.charAt(i)-'a'] == -1)
                chars[str.charAt(i)-'a'] = i;
        }
        
        for(int i = 0; i < pat.length(); i++){
            if(chars[pat.charAt(i)-'a'] == -1)
                continue;
            idx = Math.min(idx, chars[pat.charAt(i)-'a']);
        }
        return idx;
        
    }
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String pat = "set";
		System.out.println(minIndexChar(str, pat));
	}
}
