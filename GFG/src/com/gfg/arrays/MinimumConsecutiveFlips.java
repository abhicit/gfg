package com.gfg.arrays;

public class MinimumConsecutiveFlips {
	
	public static void minFlips(int[] arr) {
		int zeroFlips = 0;
		int oneFlips = 0;
		int zeroIndex = 0;
		int oneIndex = 0;
		int res = 0;
		if(arr[0] == 0) {
			zeroFlips++;
			zeroIndex = 0;
		}
		else {
			oneFlips++;
			oneIndex = 0;
		}
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == 0 && arr[i+1] == 1) {
				oneFlips++;
				oneIndex = i+1;
			}
			if(arr[i] == 1 && arr[i+1] == 0) {
				zeroFlips++;
				zeroIndex = i+1;
			}
		}
		if(oneFlips > zeroFlips)
			res = zeroIndex;
		else
			res = oneIndex;
		int count = 0;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[res]) {
				count++;
				zeroIndex = i;
				if(arr[i+1] != arr[res]) {
					System.out.println("From "+(i-count+1)+" to "+i);
					count = 0;
				}
			}
		}
		if(oneFlips == 0 || zeroFlips == 0)
			System.out.println("0");
	}
	
	public static void enhancedMinFlips(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				if(arr[i] != arr[0])
					System.out.print("From "+i+ " to ");
				else
					System.out.println(i-1);
			}
		}
		if(arr[arr.length-1] != arr[0])
			System.out.println(arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0};
		int[] arr1 = {0, 0, 1, 1, 0, 0, 1, 1, 0, 1};
		System.out.println("MinFlips method");
		minFlips(arr);
		System.out.println("Enhanced min flips method");
		enhancedMinFlips(arr1);
	}
}
