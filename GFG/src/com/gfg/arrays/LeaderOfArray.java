package com.gfg.arrays;

public class LeaderOfArray {
	
	public static void printLeader(int[] arr) {
		System.out.print(arr[arr.length-1]+" ");
		int max = 0;
		for(int i = arr.length-2; i >= 0; i--) {
			if(arr[i] > max) {
				System.out.print(arr[i]+" ");
				max = Math.max(max, arr[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 6, 5, 2};
		printLeader(arr);
	}
}
