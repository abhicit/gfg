package com.gfg.arrayRearrangement;

public class ArrangeArrayElementsOnIndex {
	public static void main(String[] args) {
		int[] arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
	              11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
		rearrange(arr);
		for(int i : arr)
			System.out.print(i+" ");
	}

	private static void rearrange(int[] arr) {
		for(int i = 0; i < arr.length; ) {
			if(arr[i] != -1) {
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
				if(arr[i] != i)
					continue;
			}
			i++;
		}
	}
}
