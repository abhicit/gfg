package com.gfg.searching;

/*
 * Given a sorted array and a sum, 
 * find if there is a pair with given sum
 */
public class TwoPointerApproach {

	public static boolean check(int[] arr, int sum, int left, int right) {// O(n)
		while (left < right) {
			if (arr[left] + arr[right] == sum)
				return true;
			else if (arr[left] + arr[right] > sum)
				right--;
			else
				left++;
		}
		return false;
	}

	public static boolean isTriplets(int[] arr, int sum, int left, int right) {//O(n^2)
		for(int i = 0; i < arr.length; i++) {
			if(check(arr, sum-arr[i], i+1, arr.length-1))
				return true;
		}
		return false;
	}
	
	public static boolean checkPythagoreanTriplets(int[] arr, int sum, int left, int right) {// O(n)
		while (left < right) {
			if ((arr[left]*arr[left]) + (arr[right]*arr[right]) == sum)
				return true;
			else if ((arr[left]*arr[left]) + (arr[right]*arr[right]) > sum)
				right--;
			else
				left++;
		}
		return false;
	}

	public static boolean isPythagoreanTriplets(int[] arr, int left, int right) {// O(n^2)
		for(int i = 0; i < arr.length; i++) {
			if(check(arr, arr[i]*arr[i], i+1, arr.length-1))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 12, 30 };
		int[] arr1 = {2, 3, 4, 5, 6, 7};
		System.out.println(check(arr, 10, 0, arr.length - 1));
		System.out.println(isTriplets(arr, 50, 0, arr.length-1));
		System.out.println(isPythagoreanTriplets(arr1, 0, arr.length-1));
	}
}
