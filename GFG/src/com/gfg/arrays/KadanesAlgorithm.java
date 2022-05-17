package com.gfg.arrays;

public class KadanesAlgorithm {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(kadaneAlgo1(arr));
		int[] arr1 = {-2, -3, -4, -1, -2, -1, -5, -3};
		System.out.println(kadaneAlgo2(arr1));
	}
	
	//handles the case where all elements are negative
	private static int kadaneAlgo2(int[] arr1) {
		int curr_max = arr1[0];
		int res = arr1[0];
		for(int i = 1; i < arr1.length; i++) {
			curr_max = Math.max(arr1[i], curr_max+arr1[i]);
			res = Math.max(res, curr_max);
		}
		return res;
	}
	
	//does not handles the case where all elements are negative
	private static int kadaneAlgo1(int[] arr) {
		int max_ending_here = 0;
		int max_so_far = 0;
		for(int i = 0; i < arr.length; i++) {
			max_ending_here += arr[i];
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if(max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}
}
