package com.gfg.slidingwindow;

/*
 * Given an array arr[] of N integers, find the length of the longest 
 * subarray having sum in the range [L, R]
 */

public class LengthOfLongestSubarray {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 6 };
        int N = arr.length;
        int L = 3, R = 8;
 
        System.out.println(largestSubArraySum(arr, N, L, R));
	}

	private static int largestSubArraySum(int[] arr, int n, int l, int r) {
		int res = 0;
		int max = 0;
		int sum = 0;
		int start = 0;
		int indexCount = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			indexCount++;
			while(sum > r && i < n) {
				max = i - start;
				sum -= arr[start];
				start++;
				res = Math.max(res, max);
				indexCount = 0;
			}
			res = Math.max(res, indexCount);
		}
		return res;
	}
}
