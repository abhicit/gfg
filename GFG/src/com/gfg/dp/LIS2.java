package com.gfg.dp;

public class LIS2 {
	public static void main(String[] args) {
		int[] arr = {8, 100, 150, 10, 12, 14, 110};
		System.out.println(lis(arr, arr.length));
	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		lis[0] = arr[0];
		int len = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] > lis[len-1]) {
				lis[len] = arr[i];
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
