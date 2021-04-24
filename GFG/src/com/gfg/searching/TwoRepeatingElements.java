package com.gfg.searching;

class Pair{
	int first;
	int second;
}

public class TwoRepeatingElements {
	
	final Pair pair = new Pair();
	
	public static int fact(int n) {
		return (n == 0) ? 1 : n * fact(n-1);
	}
	
	public Pair repeatingElements(int[] arr, int n) {
		int sum = 0;
		int product = 1;
		int diff = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			product *= arr[i];
		}
		sum = sum - n*(n+1)/2;
		product = product/fact(n);
		diff = (int)Math.sqrt(sum*sum - 4*product);
		pair.first = (diff + sum)/2;
		pair.second = (sum - diff)/2;
		return pair;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,2,4,5,2,3,1};
		int n = 5;
		TwoRepeatingElements obj = new TwoRepeatingElements();
		Pair pair = obj.repeatingElements(arr, n);
		System.out.println(pair.first+" "+pair.second);
	}
	
}
