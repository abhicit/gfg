package com.gfg.searching;

public class FirstOccurrence {
	
	public static int firstOccurrence(int[] arr, int low, int high, int term) {//recursive soln
		int mid = (low + high)/2;
		if(low > high)
			return -1;
		if(term == arr[mid]) {
			if(mid == 0 || arr[mid] != arr[mid-1])
				return mid;
			else
				return firstOccurrence(arr, low, mid-1, term);
		}
		if(term > arr[mid])
			return firstOccurrence(arr, mid+1, high, term);
		else if(term < arr[mid])
			return firstOccurrence(arr, low, mid-1, term);
		return -1;
	}
	
	public static int iterativeFirstOccurrence(int[] arr, int low, int high, int term) {//iterative soln
		while(low <= high) {
			int mid = (low+high)/2;
			if(term > arr[mid])
				low = mid+1;
			else if(term < arr[mid])
				high = mid-1;
			else if(mid == 0 || arr[mid] != arr[mid-1])
				return mid;
			else
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 10, 10, 15, 20, 20, 20};
		System.out.println(firstOccurrence(arr, 0, arr.length-1, 20));
		System.out.println(iterativeFirstOccurrence(arr, 0, arr.length-1, 15));
	}
}
