package com.gfg.arrays;

public class TrappingRainWater {
	
	public static int trappedWater(int[] arr) {
		int[] lmax = new int[arr.length];
		int[] rmax = new int[arr.length];
		int res = 0;
		lmax[0] = arr[0];
		for(int i = 1; i < lmax.length; i++) {
			lmax[i] = Math.max(arr[i], lmax[i-1]);
		}
		rmax[rmax.length-1] = arr[arr.length-1];
		for(int i = rmax.length-2; i >= 0; i--) {
			rmax[i] = Math.max(arr[i], rmax[i+1]);
		}
		for(int i = 1; i < arr.length-1; i++) {
			res = res + (Math.min(lmax[i], rmax[i])-arr[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(trappedWater(arr));
	}
}
