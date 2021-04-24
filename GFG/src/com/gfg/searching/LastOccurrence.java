package com.gfg.searching;

public class LastOccurrence {
	
	public static int lastOccurrence(int[] arr, int low, int high, int term) {//recursive
		if(low > high)
			return -1;
		int mid = (low+high)/2;
		if(term > arr[mid])
			return lastOccurrence(arr, mid+1, high, term);
		else if(term < arr[mid])
			return lastOccurrence(arr, low, mid-1, term);
		else if(mid == arr.length-1 || arr[mid] != arr[mid+1])
			return mid;
		else
			return lastOccurrence(arr, mid+1, high, term);
	}
	
	public static int iterativeLastOccurrence(int[] arr, int low, int high, int term) {
		while(low <= high) {
			int mid = (low+high)/2;
			if(term > arr[mid])
				low = mid + 1;
			else if(term < arr[mid])
				high = mid - 1;
			else if(mid == arr.length-1 || arr[mid] != arr[mid+1])
				return mid;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 20, 20, 20, 21};
		System.out.println(lastOccurrence(arr, 0, arr.length-1, 20));
		System.out.println(iterativeLastOccurrence(arr, 0, arr.length-1, 20));
	}
}
