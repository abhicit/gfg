package com.gfg.arrays;

public class MaxSumPath {
	public static int maxSum(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		int i = 0, j = 0;
		int sum1 = 0, sum2 = 0, res = 0;
		while(i < m && j < n) {
			if(arr1[i] < arr2[j])
				sum1 += arr1[i++];
			else if(arr2[j] < arr1[i])
				sum2 += arr2[j++];
			else if(arr1[i] == arr2[j]) {
				res += Math.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				while(i < m && j < n && arr1[i] == arr2[j]) {
					res += arr1[i++];
					j++;
				}
			}
		}
		
		while(i < m) {
			sum1 += arr1[i++];
		}
		while(j < n) {
			sum2 += arr2[j++];
		}
		
		return Math.max(res+sum1, res+sum2);
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {3, 4, 5};
		System.out.println(maxSum(arr1, arr2));
	}
}
