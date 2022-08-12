package com.gfg.searching;

import java.util.Arrays;

public class RepeatingMissingNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,5,5,3};
		missingRepeating1(arr);
	}

	private static void missingRepeating1(int[] arr) {//O(nlogn)
		Arrays.sort(arr);
		if(arr[0] != 1)
			System.out.println("Missing : "+1);
		else if(arr[arr.length-1] != arr.length)
			System.out.println("Missing : "+arr.length);
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1])
				System.out.println("Repeating : "+arr[i]);
			else if(arr[i] != arr[i+1] && arr[i+1] != arr[i]+1)
				System.out.println("Missing : "+(arr[i]+1));
		}
	}
	
	private static void missingRepeating2(int[] arr) {
		
	}
}
