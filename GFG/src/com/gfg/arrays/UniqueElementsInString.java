package com.gfg.arrays;

import java.util.Arrays;

public class UniqueElementsInString {
	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		long start = System.currentTimeMillis();
		System.out.println(isUniqueChars(str));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		long start1 = System.currentTimeMillis();
		System.out.println(isUniqueChars1(str));
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
	}
	
	public static boolean isUniqueChars1(String str) {
		int[] chars = new int[128];
		Arrays.fill(chars, 0);
		
		for(int i = 0; i < str.length(); i++) {
			if(chars[str.charAt(i)-'a'] == 1)
				return false;
			chars[str.charAt(i)-'a'] = 1;
		}
		
		return true;
	}
	
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
}
