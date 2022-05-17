package com.gfg.slidingwindow;

/*
 * Given two arrays W[] and C[] containing weight and cost of N (1 to N) items respectively, 
 * and an integer K, find a segment from 1 to N, such that the total weight of the segment is 
 * at most K and the total cost is maximum. Print the cost of this segment.
 */

public class MaximizeCost {
	public static void main(String[] args) {
		int W[] = {9, 7, 6, 5, 8, 4};
	    int C[] = {7, 1, 3, 6, 8, 3};
	    int N = W.length;
	    int K = 20;
	    
	    System.out.print(findMaxCost(W, C, N, K));
	}

	private static int findMaxCost(int[] weight, int[] cost, int n, int k) {
		int res = 0;
		int start = 0;
		int totalW = 0;
		int totalC = 0;
		int i = 0;
		while(i < n) {
			if(weight[i]+totalW <= k) {
				totalW += weight[i];
				totalC += cost[i];
			}else if(weight[i]+totalW > k && i < n-1) {
				totalW = totalW-weight[start]+weight[i];
				totalC = totalC-cost[start]+cost[i];
				start++;
			}
			res = Math.max(res, totalC);
			i++;
		}
		return res;
	}
}
