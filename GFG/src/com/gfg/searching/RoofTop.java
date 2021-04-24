package com.gfg.searching;

public class RoofTop {

	static int maxStep(int A[], int N){

		int steps = 0;
		int res = 0;

		for(int i = 0; i < N-1; i++){
			if(A[i] < A[i+1]){
				steps++;
			}else{
				res = steps;
				steps = 0;
			}
		}

		return Math.max(steps, res);

	}

	public static void main(String[] args) {
		int[] arr = {8,5,9,8,4};
		int n = 5;
		System.out.println(maxStep(arr, n));
	}
}
