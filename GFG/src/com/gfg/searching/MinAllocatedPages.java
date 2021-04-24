package com.gfg.searching;

public class MinAllocatedPages {
	
	public static boolean isValid(int[] arr, int k, int ans) {
		int req = 1; 
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(sum + arr[i] > ans) {
				req++;
				sum = arr[i];
			}else {
				sum += arr[i];
			}
		}
		return (req <= k);	
	}
	
	public static int minPages(int[] arr, int k) {
		int totalSum = 0;
		int maxVal = 0;
		int res = -1;
		for(int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
			maxVal = Math.max(maxVal, arr[i]);
		}
		while(maxVal <= totalSum) {
			int mid = (maxVal + totalSum)/2;
			if(isValid(arr, k, mid)) {
				res = mid;
				totalSum = mid - 1;
			}else {
				maxVal = mid + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 10, 30};
		int k = 3;
		System.out.println(minPages(arr, k));
	}
}
