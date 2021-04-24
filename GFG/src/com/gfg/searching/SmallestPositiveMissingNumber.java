package com.gfg.searching;

public class SmallestPositiveMissingNumber {
	
	public static int findMissing(int[] arr) {
		int oneCount = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				oneCount++;
			}else {
				if(arr[i] < 0 || arr[i] > arr.length+1) {
					arr[i] = 1;
				}
			}
		}
		if(oneCount == 0)
			return 1;
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			
			if(Math.abs(arr[i]) == 0)
				index = 0;
			else
				index= Math.abs(arr[i])-1;
			if(arr[index] >= 0 ) {
				arr[index] = -arr[index];
			}
		}
		int res = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0)
				return i+1;
		}
		return arr.length+1;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {25, 31, 6, -50, -21, 1, -8, -16, -1, 10, -49, 14, 14, -7, 22, 5, -39, -17, -8, 6, -10, 46, 9, -14, 8, -40, -22, -4, 47, 25, 44, -26, 6, 0, -25, 35, 3, -31, 21, 5, 30, -26, -31, 46, 17, -6, -47, -20, -21};
		System.out.println(findMissing(arr));
	}
}
