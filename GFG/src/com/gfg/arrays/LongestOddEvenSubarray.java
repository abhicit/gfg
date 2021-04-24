package com.gfg.arrays;

public class LongestOddEvenSubarray {
	
	public static int maxOddEvenSubarray(int[] arr) {
		int count = 1;
		int res = 0;
		for(int i = 1; i < arr.length; i++) {
			if((arr[i]%2 == 0 && arr[i-1]%2 != 0) || 
					(arr[i]%2 != 0 && arr[i-1]%2 == 0)) {
					count++;
			}else {
					count = 1;
			}
			res = Math.max(res, count);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 10, 20, 6, 3, 8};
		System.out.println(maxOddEvenSubarray(arr));
	}
}
