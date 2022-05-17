package com.gfg.arrays;

public class MinimumSubarraySumForEachIndex {
	public static void main(String[] args) {
		int arr[] = {5, -3, -2, 9, 4};
		minimumSubarraySum(arr);
	}

	private static void minimumSubarraySum(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(kadane(arr, i, arr.length)+" ");
		}
		
	}
	
	private static int kadane(int[] arr, int start, int end) {
		int curr_min = arr[start];
		int res = arr[start];
		for(int i = start+1; i < end; i++) {
			curr_min = Math.min(arr[i], curr_min+arr[i]);
			res = Math.min(res, curr_min);
		}
		return res;
	}
}
