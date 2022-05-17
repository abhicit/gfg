package com.gfg.prefixsum;

public class LongestZeroOneSubarray {
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 1, 1, 0, 0, 0, 0, 1};
		System.out.println(subarrayLength(arr));
	}

	private static int subarrayLength(int[] arr) {
		int res = 0;
		int sum = 0;
		int zeroes = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				++zeroes;
			}
			if(sum != 0 && sum % zeroes == 0) {
				res = Math.max(res, zeroes*2);
			}
			sum += arr[i];
		}
		return res;
	}
}
