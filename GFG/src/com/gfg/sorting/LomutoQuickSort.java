package com.gfg.sorting;

public class LomutoQuickSort {
	
	public static int partition(int[] arr, int l, int r) {
		int pivot = arr[r];
		int i = l-1;
		for(int j = l; j <= r-1; j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		
		return i+1;
	}
	
	public static void quickSort(int[] arr, int l, int r) {
		if(r > l) {
			int p = partition(arr, l, r);
			quickSort(arr, l, p-1);
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
