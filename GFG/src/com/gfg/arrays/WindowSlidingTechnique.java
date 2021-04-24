package com.gfg.arrays;

public class WindowSlidingTechnique {
	
	public static int maxSum(int[] arr, int k) {
		int res = 0;
		int maxSum = 0;
		for(int i = 0; i < k; i++) {
			maxSum += arr[i];
		}
		for(int i = k; i < arr.length; i++) {
			maxSum = maxSum - arr[i-k] + arr[i];
			res = Math.max(res, maxSum);
		}
		return res;
	}
	
	public static boolean isSumPresent(int[] arr, int sum) {
		int maxSum = arr[0];
		int start = 0;
		for(int i = 1; i < arr.length; i++) {
			maxSum += arr[i];
			while(maxSum > sum && start < i-1) {
				maxSum -= arr[start];
				start++;
			}
			if(maxSum == sum)
				return true;
		}
		return (maxSum == sum);
	}
	
	public static void main(String[] args) {
		int[] arr = {5, -10, 6, 90, 3};
		int[] arr1 = {1, 4, 0, 0, 3, 10, 5};
		System.out.println(maxSum(arr, 2));
		System.out.println(isSumPresent(arr1, 15));
	}
}
