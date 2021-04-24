package com.gfg.arrays;

public class EquilibriumPoint {
	
	public static boolean isEquilibriumPoint(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int l_sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum -= arr[i];
			if(l_sum == sum-arr[i])
				return true;
			l_sum += arr[i];
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 8, -9, 20, 6};
		System.out.println(isEquilibriumPoint(arr));
	}
}
