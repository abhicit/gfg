package com.gfg.arrays;

public class SmallestSumSubarray {
	public static void main(String[] args) {
		int arr[] = {3, -4, 2, -3, -1, 7, -5};
		System.out.println(smallestSum(arr));
	}

	private static int smallestSum(int[] arr) {
		int curr = arr[0];
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < arr.length; i++) {
			curr = Math.min(arr[i], curr+arr[i]);
			min = Math.min(min, curr);
		}
		return min;
	}
}
