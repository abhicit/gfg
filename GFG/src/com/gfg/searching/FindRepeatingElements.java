package com.gfg.searching;

public class FindRepeatingElements {
	
	public static int findRepeating(int[] arr) {
		int slow = arr[0];
		int fast = arr[0];
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow != fast);
		
		slow = arr[0];
		
		while(slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,1};
		System.out.println(findRepeating(arr));
	}
}
