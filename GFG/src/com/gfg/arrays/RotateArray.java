package com.gfg.arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int n = 10;
		int d = 3;
		rotateArr(arr, d, n);
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	static void rotateArr(int arr[], int d, int n)
    {
        
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        
    }
    
    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
