package com.gfg.recursion;

public class PrintPermutationUsingSwaps {
	public static void main(String[] args) {
		permute("ABC", 0);
	}
	
	public static void permute(String str, int n) {
		if(n == str.length()) {
			System.out.println(str);
			return;
		}
		for(int i = n; i < str.length(); i++) {
			str = swap(str, i, n);
			permute(str, n+1);
			str = swap(str, i, n);
		}
	}
	
	public static String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
}
