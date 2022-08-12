package com.gfg.arrays;

public class MaxCircularSubarraySum {
	public static void main(String[] args) {
		int[] arr = {8, -4, 3, -5, 4};
		System.out.println(maxCircular(arr));
	}

	private static int maxCircular(int[] arr) {
		int normalSum = kadane(arr);
		int circularSum = reverseKadane(arr);
		int total = 0;
		for(int i : arr)
			total += i;
		return Math.max(normalSum, total-circularSum);
	}
	
	private static int kadane(int[] arr) {
		int curr = arr[0];
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			curr = Math.max(arr[i], arr[i]+curr);
			max = Math.max(max, curr);
		}
		
		return max;
	}
	
	private static int reverseKadane(int[] arr) {
		int curr = arr[0];
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			curr = Math.min(arr[i], arr[i]+curr);
			min = Math.min(min, curr);
		}
		
		return min;
	}
}
