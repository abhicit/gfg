package com.gfg.dp;

public class CoinChangeRec {
	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 6};
		int res = getCount(arr, arr.length, 10);
		System.out.println(res);
	}

	private static int getCount(int[] arr, int n, int sum) {
		if(sum == 0)
			return 1;
		if(n == 0)
			return 0;
		int res = getCount(arr, n-1, sum);
		if(arr[n-1] <= sum)
			res += getCount(arr, n, sum-arr[n-1]);
		return res;
	}
}
