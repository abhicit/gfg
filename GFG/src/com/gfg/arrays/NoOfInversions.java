package com.gfg.arrays;

public class NoOfInversions {
	public static void main(String[] args) {
		int[] arr = {5,3,2,1,4};
		System.out.println(count(arr));
	}

	private static int count(int[] arr) {
		int res = 0;
		for(int i = 0; i < arr.length-1; i++)
			for(int j = i+1; j < arr.length; j++)
				if(arr[i] > arr[j])
					res++;
		
		return res;
	}
}
