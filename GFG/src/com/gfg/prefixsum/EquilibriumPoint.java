package com.gfg.prefixsum;

public class EquilibriumPoint {
	public static void main(String[] args) {
		int[] arr = {4, -2, 2};
		int[] arr1 = {3, 4, 8, -9, 20, 6};
		System.out.println(equilibriumPoint1(arr));
		System.out.println(equilibriumPoint2(arr1));
	}

	private static int equilibriumPoint2(int[] arr) {
		int res = -1;
		int lsum = 0;
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		for(int i = 0; i < arr.length; i++) {
			if(lsum == sum-arr[i])
				return i;
			lsum += arr[i];
			sum -= arr[i];
		}
		return res;
	}

	private static int equilibriumPoint1(int[] arr) {
		int res = -1;
		int[] presum = new int[arr.length];
		int[] suffsum = new int[arr.length];
		presum[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			presum[i] = arr[i] + presum[i-1];
		}
		
		suffsum[arr.length-1] = arr[arr.length-1];
		for(int i = arr.length-2; i >= 0; i--) {
			suffsum[i] = arr[i] + suffsum[i+1];
		}
		
		if(presum[1] == 0 || suffsum[1] == 0)
			return 0;
		else if(suffsum[arr.length-2] == 0 || suffsum[arr.length-2] == 0)
			return arr.length-2;
		
		for(int i = 1; i < arr.length-1; i++) {
			if(presum[i-1] == suffsum[i+1]) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	
}
