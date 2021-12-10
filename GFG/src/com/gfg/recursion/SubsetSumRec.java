package com.gfg.recursion;

public class SubsetSumRec {
	public static void main(String[] args) {
		int[] arr = {10, 20, 15, 5};
		int sum = 25;
		System.out.println(countSubset(arr, 0, sum));
	}

	private static int countSubset(int[] arr, int n, int sum) {
		if(n == arr.length) {
			return (sum == 0) ? 1 : 0;
		}
		return countSubset(arr, n+1, sum) + 
				countSubset(arr, n+1, sum-arr[n]);
	}
}
