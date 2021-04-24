package com.gfg.arrays;

public class MoveZeroesToEnd {
	
	public static int[] zeroesToEnd(int[] arr) {
		for(int i = arr.length-1; i >= 0; i--) {
			int temp = arr.length-1;
			if(arr[i] == 0 && i != arr.length-1) {
				int counter = i;
				while(counter != temp) {
					arr[counter] = arr[counter+1];
					counter++;
				}
				arr[temp] = 0;
				temp = i;
			}
		}
		return arr;
	}
	
	public static int[] toEnd(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 0, 0, 8, 0, 9, 0};
		int[] res = zeroesToEnd(arr);
		int[] res1 = toEnd(arr);
		for(int i : res)
			System.out.print(i+" ");
		System.out.println();
		for(int i : res1)
			System.out.print(i+" ");
	}
}
