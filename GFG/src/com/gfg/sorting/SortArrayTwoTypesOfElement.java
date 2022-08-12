package com.gfg.sorting;

public class SortArrayTwoTypesOfElement {
	public static void main(String[] args) {
		int[] arr = {-12, 18, -4, 45, -10, 15};
		sort(arr);
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void sort(int[] arr) {
		int i = -1;
		int j = arr.length;
		while(true) {
			do {
				i++;
			}while(arr[i] <= 0);
			
			do {
				j--;
			}while(arr[j] > 0);
			
			if(i >= j)
				return;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
