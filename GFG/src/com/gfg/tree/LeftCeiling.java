package com.gfg.tree;

import java.util.Arrays;
import java.util.TreeSet;

public class LeftCeiling {
	public static void main(String[] args) {
		int[] arr = {2, 8, 30, 15, 25, 12};
		ceil(arr);
	}

	private static void ceil(int[] arr) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(arr[0]);
		System.out.println(-1);
		for(int i = 1; i < arr.length; i++) {
			if(ts.ceiling(arr[i]) != null)
				System.out.println(ts.ceiling(arr[i]));
			else
				System.out.println(-1);
			ts.add(arr[i]);
		}
	}
}
