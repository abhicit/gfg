package com.beingSingle;

public class Test7 {
	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 9, 1};
		int n = 4;
		search(arr, n);
	}

	private static void search(int[] arr, int n) {
		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n) {
				index = i;
				System.out.println("Index : "+index);
				break;
			}
		}
		if(index == -1)
			System.out.println(n+" is not present in the array");
	}
}
