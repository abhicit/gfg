package com.gfg.arrays;

public class MaximumSumCircularSubArray {
	
	public static int maxSumCircularSubArray(int[] arr) {
		int res = arr[0];
		int sum = arr[0];
		for(int i = 1; i < arr.length; i++) {
			sum = Math.max(sum+arr[i], arr[i]);
			res = Math.max(sum, res);
		}
		return res;
	}
	
	public static int circSum(int[] arr) {
		int maxNormSum = maxSumCircularSubArray(arr);
		if(maxNormSum < 0)
			return maxNormSum;
		int arrSum = 0;
		for(int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
			arr[i] = -arr[i];
		}
		int maxCircSum = arrSum + maxSumCircularSubArray(arr);
		return Math.max(maxNormSum, maxCircSum);
	}
	
	public static void main(String[] args) {
		int[] arr = {10, -5, 5};
		System.out.println(circSum(arr));
	}
}
