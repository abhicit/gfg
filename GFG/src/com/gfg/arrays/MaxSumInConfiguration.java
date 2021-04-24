package com.gfg.arrays;

//Formula to solve this problem
/*next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] * (n-1);



next_val = Value of sum of i*arr[i] after one rotation.

curr_val = Current value of sum of i*arr[i] 

cum_sum = Sum of all array elements, i.e., sum of arr[i]
 */

public class MaxSumInConfiguration {
	static int max_sum(int A[], int n)
    {
	    int totalSum = 0;
	    for(int i = 0; i < n; i++) {
	    	totalSum += A[i];
	    }
	    
	    int currVal = 0;
	    for(int i = 0; i < n; i++) {
	    	currVal += A[i]*i;
	    }
	    
	    int res = currVal;
	    
	    for(int i = 1; i < n; i++) {
	    	int nextVal = currVal - (totalSum - A[i-1]) + A[i-1] * (n-1);
	    	currVal = nextVal;
	    	res = Math.max(res, nextVal);
	    }
	    
	    return res;
    }
    
    public static void main(String[] args) {
		int[] A = {887, 778, 916, 794, 336, 387, 493, 650, 422, 363, 28, 691, 60, 764, 927, 541, 427, 173, 737, 212, 369, 568, 430, 783, 531, 863, 124, 68, 136, 930, 803, 23, 59, 70, 168, 394, 457, 12, 43, 230, 374, 422, 920, 785, 538, 199, 325, 316, 371, 414, 527, 92, 981, 957, 874, 863, 171, 997, 282, 306, 926, 85, 328, 337, 506, 847, 730, 314, 858, 125, 896, 583, 546, 815, 368, 435, 365, 44, 751, 88, 809, 277, 179, 789};
		System.out.println(max_sum(A, A.length));
	}
}
