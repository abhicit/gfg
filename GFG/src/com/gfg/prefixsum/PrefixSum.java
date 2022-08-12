package com.gfg.prefixsum;

public class PrefixSum {
	public static void main(String[] args) {
		int[] arr = {2, 8, 3, 9, 6, 5, 4};
		System.out.println(getSum(arr, 0, 2));
		System.out.println(getSum(arr, 1, 3));
	}

	private static int getSum(int[] arr, int start, int end) {
		int[] presum = new int[arr.length];
		presum[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			presum[i] = arr[i] + presum[i-1];
		}
		
		return (start == 0) ? presum[end] : presum[end] - presum[start-1];
	}
}
