package com.gfg.searching;

public class PeakInAnArray {
	
	public static int peakEfficient(int[] arr, int low, int high) {//O(log n)
		while(low <= high) {
			int mid = (low+high)/2;
			if((mid == 0 || arr[mid-1] <= arr[mid]) &&
					(mid == arr.length-1 || arr[mid] >= arr[mid+1]))
				return mid;
			if(mid > 0 && arr[mid-1] >= arr[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	public static int peakNaive(int[] arr) {//O(n)
		int res = 0;
		if(arr.length == 1)
			return arr[0];
		if(arr.length == 2 && arr[0] >= arr[1])
			return arr[0];
		if(arr.length == 2 && arr[arr.length-1] >= arr[arr.length-2])
			return arr[arr.length-1];
		for(int i = 1; i < arr.length-1; i++) {
			if(arr[i] >= arr[i-1] &&
					arr[i] >= arr[i+1])
				res = arr[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 7, 8, 20, 12};
		System.out.println(peakNaive(arr));
		int[] arr1 = {1, 2, 3};
		System.out.println(peakEfficient(arr1, 0, arr.length-1));
	}
}
