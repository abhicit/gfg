package com.gfg.searching;

public class Count1s {

	public static int countOf1(int[] arr, int low, int high) {

		/*while(low <= high) { 
			int mid = (low+high)/2; 
			if(1 > arr[mid]) 
				low = mid+1;
		else if(1 < arr[mid])
			high = mid-1; 
		else { 
			if(mid == 0 || arr[mid-1] == 0)
				return arr.length - mid; 
			else 
				high = mid-1; 
			} 
		}*/


		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] < 1){
				high = mid - 1;
			}else{
				if(mid == 0 || arr[mid+1] == 0)
					return mid+1;
				else
					high = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,1,0,0,0};
		System.out.println(countOf1(arr, 0, arr.length-1));
	}
}
