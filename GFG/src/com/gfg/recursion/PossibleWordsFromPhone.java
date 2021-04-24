package com.gfg.recursion;

import java.util.ArrayList;

public class PossibleWordsFromPhone {
	
	static String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void possibleWords(int[] arr, int n){
		String curr = "";
		int index = 0;
		printWords(arr, n, curr, index);
	}
	
	public static void printWords(int[] arr, int n, String curr, int index) {
		if(n == index) {
			System.out.print(curr+" ");
			return;
		}else {
			for(int i = 0; i < key[arr[index]].length(); i++) {
				printWords(arr, n, curr+key[arr[index]].charAt(i), index+1);
			}
		}
	}

	public static void main(String[] args) {
		int [] arr = {2,3,4};
		possibleWords(arr, arr.length);
	}
}
