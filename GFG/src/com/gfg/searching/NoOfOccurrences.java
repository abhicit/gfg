package com.gfg.searching;

public class NoOfOccurrences {
	
	public static int firstOccurrence(int[] arr, int low, int high, int term) {
		while(low <= high) {
			int mid = (low+high)/2;
			if(term > arr[mid])
				low = mid+1;
			else if(term < arr[mid])
				high = mid-1;
			else {
				if(mid == 0 || arr[mid] != arr[mid-1])
					return mid;
				else
					high = mid-1;
			}
		}
		return -1;
	}
	
	public static int lastOccurrence(int[] arr, int low, int high, int term) {
		while(low <= high) {
			int mid = (low+high)/2;
			if(term > arr[mid])
				low = mid+1;
			else if(term < arr[mid])
				high = mid-1;
			else {
				if(mid == arr.length-1 || arr[mid] != arr[mid+1])
					return mid;
				else
					low = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 10, 10, 10, 15, 20, 20, 20, 20};
		int first = firstOccurrence(arr, 0, arr.length-1, 5);
		if(first == -1) {
			System.out.println(-1);
			return;
		}
		System.out.println(lastOccurrence(arr, 0, arr.length-1, 5)-first+1);
	}
}
