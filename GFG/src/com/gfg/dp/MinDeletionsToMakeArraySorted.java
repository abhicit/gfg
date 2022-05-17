package com.gfg.dp;

public class MinDeletionsToMakeArraySorted {
	public static void main(String[] args) {
		int[] arr = {5, 10, 3, 6, 7, 8};
		int n = lis(arr, arr.length);
		System.out.println("Minimum deletions required to make array sorted : "+(arr.length-n));
	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		lis[0] = arr[0];
		int len = 1;
		
		for(int i = 1; i < n; i++) {
			if(arr[i] > lis[len-1]) {
				lis[i] = arr[i];
				len++;
			}else {
				int c = ceilIdx(lis, 0, len-1, arr[i]);
				lis[c] = arr[i];
			}
		}
		
		return len;
	}

	private static int ceilIdx(int[] lis, int l, int r, int x) {
		while(r > l) {
			int m = l + (r-l)/2;
			if(lis[m] >= x)
				r = m;
			else
				l = m+1;
		}
		return r;
	}
}
