package com.gfg.searching;

/*
 * {2,3,4,5,5}
 */

class Point{
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
}

public class CountRepeatingNumbers {
	
	public static Point findRepeatingNaive(Integer[] arr, int n) {//O(n)
		int term = 0;
		int count = 1;
		for(int i = 1; i < n; i++) {
			if(arr[i] == arr[i-1]) {
				count++;
				term = arr[i];
			}
		}
		return new Point(term, count);
	}
	
	public static Point findRepeatingOptimal(Integer[] arr, int n) {
		if(arr.length == 0)
			return new Point(0,0);
		int start = 0;
		int end = n-1;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid] >= mid+arr[0])
				start = mid + 1;
			else
				end = mid;
		}
		return new Point(arr[start], n - arr[n-1] + arr[0]);
	}
	
	public static void main(String[] args) {	
		Integer[] arr = {1,1,2,3,4,5};
		int n = 5;
		Point pair1 = findRepeatingOptimal(arr, n);
		System.out.println("Optimal : "+pair1.x+ " " +pair1.y);
		
	}
}
