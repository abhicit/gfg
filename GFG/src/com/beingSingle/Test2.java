package com.beingSingle;

public class Test2 {
	public static int sumOddLengthSubarrays(int[] arr) {
		int res = 0;
        int counter = 0;
        int innerCounter = 0;
        while(counter < arr.length) {
        	for(int i = 0; i+counter < arr.length; i++) {
        		int j = i;
        		innerCounter = counter;
        		while(innerCounter >= 0 && j < arr.length) {
        			res += arr[j];
        			j++;
        			innerCounter--;
        		}
        	}
        	counter += 2;
        }
        return res;
    }
	
	public static int sumOddLengthSubarraysEfficient(int[] arr) {
		int i,s=0;
		int l=arr.length;
		int start[]=new int[l];
		int end[]=new int[l];
		for(i=0;i<l;i++){
			start[i]=l-i;
			end[i]=i+1;
			s+=(arr[i])*((start[i]*end[i]%2==0?(start[i]*end[i])/2:(start[i]*end[i])/2+1));
		}
		return s;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,11,12};
		System.out.println(sumOddLengthSubarraysEfficient(arr));
	}
}
