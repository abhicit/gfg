package com.gfg.arrays;

public class SegregateElements {
	public static void main(String[] args) {
		int[] arr = {-5, 7, -3, -4, 9, 10, -1, 11};
		segregateElements(arr, arr.length);
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	public static void segregateElements(int arr[], int n)
    {
		int neg = n-1;
		int pos = 0;
        int[] temp = new int[n];
        for(int i = 0, j = n-1; i < n && j >= 0; i++, j--){
            if(arr[i] >= 0){
                temp[pos++] = arr[i];
            }
            
            if(arr[j] < 0){
                temp[neg--] = arr[j];
            }
        }
        
        for(int i = 0; i < n; i++)
            arr[i] = temp[i];
    }
}
