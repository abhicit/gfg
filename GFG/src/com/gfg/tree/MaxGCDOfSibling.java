package com.gfg.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxGCDOfSibling {
	static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        
        for(int i = 0; i < N-1; i++){
            if(arr.get(i).get(0) == arr.get(i+1).get(0)){
                int gcd = gcd(arr.get(i).get(1), arr.get(i+1).get(1));
                max = Math.max(max, gcd);
                res = Math.max(max, res);
            }
        }
        
        return res;
    }
    
    static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
    
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < 6; i++) {
    		arr.add(new ArrayList<>());
    	}
		arr.get(0).add(1);
		arr.get(0).add(8);
		arr.get(1).add(1);
		arr.get(1).add(16);
		arr.get(2).add(16);
		arr.get(2).add(21);
		arr.get(3).add(8);
		arr.get(3).add(9);
		arr.get(4).add(9);
		arr.get(4).add(18);
		arr.get(5).add(8);
		arr.get(5).add(18);
		System.out.println(maxBinTreeGCD(arr, arr.size()));
	}
}
