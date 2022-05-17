package com.gfg.slidingwindow;

/*
 * Given an array arr[] of length N, the task is to find 
 * the minimum product of subarray of size K of an array 
 * including negative integers.
 */

public class MinProductSubarray {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 0, -5, 4, 1 };
		int k = 3;
		System.out.println(minProdK(arr, k));
	}

	private static int minProdK(int[] arr, int k) {
		int res = 0;
		int prod = 1;
		int zeroes = 0;
		for(int i = 0; i < k; i++) {
			if(arr[i] == 0)
				zeroes++;
			else
				prod *= arr[i];
		}
		
		res = (zeroes == 0) ? prod : 0;
		
		for(int i = k; i < arr.length; i++) {
			if(arr[i] == 0)
				zeroes++;
			else {
				if(arr[i-k] == 0) {
					zeroes--;
					prod *= arr[i];
				}
				else
					prod = (prod/arr[i-k]) * arr[i];
			}
			
			if(zeroes == 0)
				res = Math.min(res, prod);
			else if(zeroes > 0 && res > 0)
				res = Math.min(res, 0);
			
		}
		return res;
	}
}
