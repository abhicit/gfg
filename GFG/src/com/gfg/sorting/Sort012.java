package com.gfg.sorting;

public class Sort012 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 1, 1, 2};
		sort(arr);
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void sort(int[] arr) {
		int low = 0, mid = 0, hi = arr.length-1;
		while(mid <= hi) {
			if(arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			}else if(arr[mid] == 1) {
				mid++;
			}else {
				swap(arr, mid, hi);
				hi--;
			}
		}
	}

	private static void swap(int[] arr, int low, int mid) {
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
	}
}
