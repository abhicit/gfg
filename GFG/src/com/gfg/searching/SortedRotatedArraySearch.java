package com.gfg.searching;

public class SortedRotatedArraySearch {
	
	public static int find(int[] arr, int low, int high, int term) {
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == term)
				return mid;
			if(arr[mid] > arr[low]) {
				if(arr[low] <= term && term < arr[mid])
					high = mid-1;
				else
					low = mid+1;
			}else {
				if(arr[mid] < term && term <= arr[high])
					low = mid+1;
				else
					high = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {100, 200, 300, 400, 10, 20, 40};
		System.out.println(find(arr, 0, arr.length-1, 100));
	}
}
