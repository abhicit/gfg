package com.gfg.sorting;

public class MergeInPlace {
	
	public static int nextGap(int gap) {
		if(gap <= 1)
			return 0;
		return (gap/2) + (gap%2);
	}
	
	public static void merge(int[] arr1, int[] arr2, int n, int m) {
		int gap = m+n, i, j, temp;
		for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
			for(i = 0; i+gap < n; i++) {
				if(arr1[i] > arr1[i+gap]) {
					temp = arr1[i];
					arr1[i] = arr1[i+gap];
					arr1[i+gap] = temp;
				}
			}
			
			for (j = /* (gap > n)? gap - n : */0; i < n && j < m; i++, j++) {
				if(arr1[i] > arr2[j]) {
					temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}
			}
			
			if(j < m) {
				for(j = 0; j+gap < m; j++) {
					if(arr2[j] > arr2[j+gap]) {
						temp = arr2[j];
						arr2[j] = arr2[j+gap];
						arr2[j+gap] = temp;
					}
				}
			}
		}
		for(int it : arr1)
			System.out.print(it+ " ");
		System.out.println();
		for(int it : arr2)
			System.out.print(it+ " ");
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7};
		int[] arr2 = {0, 2, 6, 8, 9};
		merge(arr1, arr2, arr1.length, arr2.length);
	}
	
}
