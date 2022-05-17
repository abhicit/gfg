package com.gfg.arrays;

/*
 * Given an array arr[] consisting of N integers, the task is to find the maximum sum 
 * of any subarray possible after removing at most one subarray from the given array
 */

public class MaxSumSubarray1 {
	public static void main(String[] args) {
		int[] arr = {7, 6, -1, -4, -5, 7, 1, -2, -3};
		System.out.println(maxSumSubarray(arr));
	}

	private static int maxSumSubarray(int[] arr) {
		
		int[] preSum = new int[arr.length];
		int currSum = 0;
		int maxSum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			currSum = Math.max(arr[i], currSum+arr[i]);
			maxSum = Math.max(maxSum, currSum);
			preSum[i] = maxSum;
		}
		
		int[] postSum = new int[arr.length+1];
		currSum = 0;
		maxSum = 0;
		
		for(int i = arr.length-1; i >= 0; i--) {
			currSum = Math.max(arr[i], currSum+arr[i]);
			maxSum = Math.max(maxSum, currSum);
			postSum[i] = maxSum;
		}
		
		int res = 0;
		for(int i = 0; i < arr.length; i++) {
			res = Math.max(res, preSum[i]+postSum[i+1]);
		}
		
		return res;
	}
}
