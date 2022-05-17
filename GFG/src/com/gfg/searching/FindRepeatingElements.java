package com.gfg.searching;

public class FindRepeatingElements {
	
	public static int findRepeating(int[] arr) {
		int slow = arr[0];
		int fast = arr[0];
		do {
			slow = arr[slow]+1;
			fast = arr[arr[fast]+1]+1;
		}while(slow != fast);
		
		slow = arr[0];
		
		while(slow != fast) {
			slow = arr[slow]+1;
			fast = arr[fast]+1;
			slow++;
			fast--;
		}
		return slow-1;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,3,2,4,6,5,7,3};
		System.out.println(findRepeating(arr));
	}
}
