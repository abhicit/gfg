package com.gfg.arrays;

import java.util.Arrays;

class Pairs{
	int first;
	boolean second;
	
	Pairs(int first, boolean second){
		this.first = first;
		this.second = second;
	}
}

public class MaximumCarParked {
	public static void main(String[] args) {
		int[][] arr = { { 1012, 1136 },
                { 1317, 1412 },
                { 1015, 1020 } };
		System.out.println(maxCarsParked(arr));
	}

	private static int maxCarsParked(int[][] arr) {
		Pairs[] a = new Pairs[2*arr.length];
		for(int i = 0; i < arr.length; i++) {
			a[2*i] = new Pairs(arr[i][0], true);
			a[2*i+1] = new Pairs(arr[i][1], false);
		}
		
		Arrays.sort(a, (p1, p2) -> p1.first-p2.first);
		
		int curr = 0;
		int res = 0;
		
		for(int i = 0; i < 2*arr.length; i++) {
			if(a[i].second)
				curr++;
			else {
				if(curr > res)
					res = curr;
				curr--;
			}
		}
		return res;
	}
	
	
}
