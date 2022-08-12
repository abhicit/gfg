package com.gfg.arrays;

public class MaxProductSubArraySumMaxElement {
	public static void main(String[] args) {
		int arr[] = {2, -3, 8, -2, 5};
		System.out.println(maxProduct(arr));
	}

	private static int maxProduct(int[] arr) {
		int maxElement = Integer.MIN_VALUE;
		int curr_max = Integer.MIN_VALUE;
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			maxElement = Math.max(maxElement, arr[i]);
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			res = Math.max(res, curr_max);
		}
		return res*maxElement;
	}
}
