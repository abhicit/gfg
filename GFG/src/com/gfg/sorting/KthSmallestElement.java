package com.gfg.sorting;

public class KthSmallestElement {
	public static int kthSmallest(int arr[], int n, int k){
        int l = 0;
        int h = n-1;
        while(l <= h) {
            int p = partition(arr, l, h);
            if(p == k-1) {
            	return arr[p];
            }else if(p > k-1) {
            	h = p-1;
            }else {
            	l = p+1;
            }
        }
        return 1;
    }
    
    public static int partition(int arr[], int l, int h){
        int pivot = arr[h];
        int i = l-1;
        for(int j = l; j <= h-1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;
        return i+1;
    }
    
    public static void main(String[] args) {
		int[] arr = {4, 3, 7, 6, 5};
		int n = arr.length;
		int k = 5;
		System.out.println(kthSmallest(arr, n, k));
	}
}
