package com.gfg.sorting;

public class CountInversion {
	public static void main(String[] args) {
		int[] arr = {5,3,2,1,4};
		int[] temp = new int[arr.length];
		System.out.println(mergeSort(arr, temp, 0, arr.length-1));
	}

	private static int mergeSort(int[] arr, int[] temp, int left, int right) {
		int mid, count = 0;
		if(left < right) {
			mid = (left+right)/2;
			count += mergeSort(arr, temp, left, mid);
			count += mergeSort(arr, temp, mid+1, right);
			count += merge(arr, temp, left, mid+1, right);
		}
		return count;
	}

	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int count = 0;
		int i = left;
		int j = mid;
		int k = left;
		
		while((i <= mid-1) && (j <= right)) {
			if(arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else {
				temp[k++] = arr[j++];
				count = count + (mid-i);
			}
		}
		
		while(i <= mid - 1)
	        temp[k++] = arr[i++];

	    while(j <= right)
	        temp[k++] = arr[j++];

	    for(i = left ; i <= right ; i++)
	        arr[i] = temp[i];
	    
	    return count;
	}
}
