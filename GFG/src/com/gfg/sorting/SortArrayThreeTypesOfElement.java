package com.gfg.sorting;

public class SortArrayThreeTypesOfElement {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 0, 1, 1, 2};
		sort(arr);
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void sort(int[] arr) {
		int l = 0, r = arr.length-1, m = 0;
		while(m <= r) {
			if(arr[m] == 0) {
				int temp = arr[m];
				arr[m] = arr[l];
				arr[l] = temp;
				l++;
				m++;
			}else if(arr[m] == 1) {
				m++;
			}else {
				int temp = arr[m];
				arr[m] = arr[r];
				arr[r] = temp;
				r--;
			}
		}
	}
}
