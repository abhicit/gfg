package com.gfg.arrays;

public class RotatedAndSorted {
	
	public static boolean checkRotatedAndSorted(int arr[], int n){
		int minIndex = 0;
		int min = arr[0];
		for(int i = 0; i < n; i++) {
			if(arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		
		for(int i = 0; i < minIndex-1; i++) {
			if(arr[i] < arr[i+1])
				return false;
		}
		
		for(int i = minIndex+1; i < n-1; i++) {
			if(arr[i] < arr[i+1])
				return false;
		}
		
        return true;
    }
	
	 public static void main(String[] args) {
		int[] arr = {10, 20, 30, 14};
		System.out.println(checkRotatedAndSorted(arr, arr.length));
	 }
}
