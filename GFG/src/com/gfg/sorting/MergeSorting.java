package com.gfg.sorting;

public class MergeSorting {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 0, 9, 8};
		sort(arr, 0, arr.length-1);
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void sort(int[] arr, int l, int r) {
		if(r > l) {
			int mid = l+(r-l)/2;
			sort(arr, l, mid);
			sort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i = 0; i < n1; i++)
			left[i] = arr[l+i];
		for(int i = 0; i < n2; i++)
			right[i] = arr[mid+i+1];
		
		int i = 0, j = 0, k = l;
		while(i < n1 && j < n2) {
			if(left[i] <= right[j]) 
				arr[k++] = left[i++];
			else 
				arr[k++] = right[j++];
		}
		while(i < n1) 
			arr[k++] = left[i++];
		while(j < n2) 
			arr[k++] = right[j++];
	}
}
