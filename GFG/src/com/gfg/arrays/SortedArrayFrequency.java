package com.gfg.arrays;

public class SortedArrayFrequency {
	
	public static void printFrequency(int[] arr) {
		int count = 1;
		int curr = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			if(curr == arr[i+1]) {
				count++;
			}else {
				System.out.println(curr+" : "+count);
				count = 1;
				curr = arr[i+1];
			}
			if(i+1 == arr.length-1)
				System.out.println(arr[i+1]+" : "+count);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 30, 30, 40, 40};
		printFrequency(arr);
	}
}
