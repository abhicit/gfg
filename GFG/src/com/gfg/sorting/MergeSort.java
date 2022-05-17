package com.gfg.sorting;

public class MergeSort {
	
	public static void merge(int[] arr, int l, int m, int r) {
		int[] left = new int[m-l+1];
		int[] right = new int[r-m];
		for(int i = 0; i < left.length; i++)
			left[i] = arr[i+l];
		
		for(int i = 0; i < right.length; i++)
			right[i] = arr[m+1+i];
		
		int i = 0, j = 0, k = l;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
			}
		}
		while(i < left.length)
			arr[k++] = left[i++];
		while(j < right.length)
			arr[k++] = right[j++];
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if(r > l) {
			int m = l + (r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 6, 1, 8, 6, 9, 2};
		mergeSort(arr, 0, arr.length-1);
		for(int i : arr)
			System.out.print(i+" ");
	}
	
}
