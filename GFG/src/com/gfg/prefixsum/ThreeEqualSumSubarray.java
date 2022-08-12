package com.gfg.prefixsum;

public class ThreeEqualSumSubarray {
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,1,3,5};
		System.out.println(isPossible(arr));
	}

	private static boolean isPossible(int[] arr) {
		boolean res = false;
		int sum = 0;
		int temp = 0;
		int count = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		if(sum % 3 == 0) {
			for(int i = 0; i < arr.length; i++) {
				if(temp == sum/3) {
					count++;
					temp = 0;
				}
				temp += arr[i];
			}
			count = (temp == sum/3) ? ++count : count;
			res = (count == 3) ? true : false;
		}
		return res;
	}
}
