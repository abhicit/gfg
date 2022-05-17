package com.gfg.prefixsum;

public class SubarrayWithSumZero {
	public static void main(String[] args) {
		int[] arr = {4, -2, 1};
		System.out.println(isSumZero(arr));
	}

	private static boolean isSumZero(int[] arr) {
		boolean res = false;
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(sum - arr[i] == 0 || arr[i] == 0)
				return true;
		}
		return res;
	}
}
