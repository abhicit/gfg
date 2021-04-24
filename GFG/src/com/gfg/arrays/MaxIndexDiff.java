package com.gfg.arrays;

import java.util.Arrays;

public class MaxIndexDiff {
	
	public static int maxIndexDiff1(int[] arr, int n) { //O(n^2)
		int maxDiff = 0;
		int diff = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(arr[i] <= arr[j]) {
					diff = j - i;
					maxDiff = Math.max(diff, maxDiff);
				}
			}
		}
		return maxDiff;
	}
	
	public static int maxIndexDiff2(int[] arr, int n) { //O(n*logn)
		int[] maxFromEnd = new int[n+1];
		Arrays.fill(maxFromEnd, Integer.MIN_VALUE);
		for (int i = n - 1; i >= 0; i--) 
		  {
		    maxFromEnd[i] = Math.max(maxFromEnd[i + 1], arr[i]);
		  }
		int result = 0;

		  for (int i = 0; i < n; i++) 
		  {
		    int low = i + 1, high = n - 1, 
		        ans = i;

		    while (low <= high) 
		    {
		      int mid = (low + high) / 2;

		      if (arr[i] <= maxFromEnd[mid]) 
		      {
		        // We store this as current 
		        // answer and look for further 
		        // larger number to the right side
		        ans = Math.max(ans, mid);
		        low = mid + 1;
		      }
		      else 
		      {
		        high = mid - 1;
		      }
		    }
		    
		    // Keeping a track of the
		    // maximum difference in indices
		    result = Math.max(result, ans - i);
		  }
		  return result;
	}
	
	public static int maxIndexDiff3(int arr[], int n) //O(n), O(n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(arr[j], RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }
	
	public static void main(String[] args) {
		int[] arr = {65, 6, 74, 94, 56, 89, 9, 63, 75, 25, 34, 68, 93, 48, 16};
		int n = 15;
		System.out.println(maxIndexDiff1(arr, n));
		System.out.println(maxIndexDiff2(arr, n));
		System.out.println(maxIndexDiff3(arr, n));
	}
}
