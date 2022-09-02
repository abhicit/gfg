package com.gfg.arrays;

public class EquilibriumPoint {
	
	public static boolean isEquilibriumPoint(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int l_sum = 0;
		for(int i = 0; i < arr.length; i++) {
			if(l_sum == sum-arr[i])
				return true;
			l_sum += arr[i];
			sum -= arr[i];
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, -2, 4};
		System.out.println(isEquilibriumPoint(arr));
	}
}
