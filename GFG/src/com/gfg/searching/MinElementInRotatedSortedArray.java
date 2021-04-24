package com.gfg.searching;

public class MinElementInRotatedSortedArray {
	
	public static int findMin(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		if(arr.length == 1)
			return arr[0];
		while(low <= high) {
			int mid = (low+high)/2;
			if((mid == 0 || arr[mid] <= arr[mid-1]) && (mid == arr.length-1 || arr[mid] <= arr[mid+1]))
				return arr[mid];
			if(arr[mid] > arr[high])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,1};
		System.out.println(findMin(arr));
	}
}
