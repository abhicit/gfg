package com.gfg.sorting;

public class HoareQuickSort {
	
	public static int partition(int[] arr, int l, int r) {
		int i = l-1;
		int j = r+1;
		int pivot = arr[l];
		while(true) {
			do {
				i++;
			}while(arr[i] < pivot);
			
			do {
				j--;
			}while(arr[j] > pivot);
			
			if(i >= j)
				return j;
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	public static void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int p = partition(arr, l, r);
			quickSort(arr, l, p);
			quickSort(arr, p+1, r);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 6, 1, 8, 6, 9, 2};
		quickSort(arr, 0, arr.length-1);
		for(int i : arr)
			System.out.print(i+" ");
	}
	
}
