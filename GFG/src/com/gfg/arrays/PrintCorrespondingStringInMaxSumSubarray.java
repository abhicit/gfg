package com.gfg.arrays;

import java.util.Arrays;

class StringPair{
	String str;
	int n;
	
	StringPair(String str, int n){
		this.str = str;
		this.n = n;
	}
}

public class PrintCorrespondingStringInMaxSumSubarray {
	public static void main(String[] args) {
		StringPair[] arr = {new StringPair("practice", -7), new StringPair("makes", -2), new StringPair("men perfect", 5)};/*{new StringPair("geeks", 4), new StringPair("for", -3), 
				new StringPair("geeks", 2), new StringPair("tutorial", 3), new StringPair("program", -4)}*/;
		printString(arr);
	}

	private static void printString(StringPair[] arr) {
		int pstart = 0;
		int pend = 0;
		int curr = 0;
		int max = 0;
		int start = 0;
		int end = 0;
		
		/*boolean[] flag = new boolean[arr.length];
		Arrays.fill(flag, false);*/
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].n <= arr[i].n+curr) {
				curr = arr[i].n+curr;
				pstart = i;
				pend = i;
				if(curr <= 0)
					start = pstart;
			}
			if(max < curr) {
				max = curr;
				end = pend;
			}
		}
		
		for(int i = start; i <= end; i++)
			System.out.print(arr[i].str+" ");
	}
}
