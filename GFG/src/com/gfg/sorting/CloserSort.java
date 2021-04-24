package com.gfg.sorting;

public class CloserSort {
	static long closer(int arr[], int n, long x)
    {
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == x){
                return 1l;
            }else if(mid+1 < n && x >= arr[mid+1]){
                low = mid+1;
            }else if(mid-1 > 0 && x <= arr[mid-1]){
                high = mid-1;
            }else if((mid == n-1 || mid == 0) && (arr[n-1] == x || arr[0] == x)) {
            	return 1l;
            }else if((mid == n-1 || mid == 0) && (arr[n-1] != x || arr[0] != x)) {
            	return -1;
            }
        }
        return -1l;
    }
	
	public static void main(String[] args) {
		int[] arr = {3, 2, 10, 4, 40};
		int n = arr.length;
		System.out.println(closer(arr, n, 3));
	}
}
