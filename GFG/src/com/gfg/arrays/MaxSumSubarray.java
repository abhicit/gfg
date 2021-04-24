package com.gfg.arrays;

public class MaxSumSubarray {
	
	public static int maxSum(int[] arr) {
		int res = arr[0];
		int sum = arr[0];
		for(int i = 1; i < arr.length; i++) {
			sum = Math.max(sum+arr[i], arr[i]);
			res = Math.max(res, sum);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.println(maxSum(arr));
	}
}
