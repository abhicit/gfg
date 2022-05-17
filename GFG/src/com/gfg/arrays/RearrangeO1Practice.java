package com.gfg.arrays;

public class RearrangeO1Practice {
	static void arrange(long arr[], int n)
	{
		long max = Long.MIN_VALUE;
		for(long i : arr)
			max = Math.max(max, i);
		
		max++;
		
		for(int i = 0; i < n; i++){
			arr[i] = (arr[(int)(arr[i]%max)] > max) ? 
					((arr[(int)(arr[i]%max)]%max) * max)+arr[i] : 
						(arr[(int)(arr[i]%max)] * max)+arr[i];
		}

		for(int i = 0; i < n; i++)
			arr[i] /= max;
	}

	public static void main(String[] args) {
		long[] arr = {1, 0};
		arrange(arr, arr.length);
		for(long i : arr)
			System.out.print(i+" ");
	}
}
