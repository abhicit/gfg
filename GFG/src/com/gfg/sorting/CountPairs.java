package com.gfg.sorting;

import java.util.Arrays;

public class CountPairs {
	static long countPairs(int x[], int y[], int n, int m)
    {
        int res = 0;
        Arrays.sort(y);
        for(int j = 0; j < m; j++){
            int i = 0;
            while(i < n){
            	if(y[j] == 1 && x[i] == 1) {
            		i++;
            		continue;
            	}
                if(y[j] == 1){
                    res++;
                }else if(y[j] > x[i] && x[i] != 1){
                    res += m-j;
                }
                i++;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] x = {2, 3, 4, 5};
		int[] y = {1, 2, 3};
		int n = x.length;
		int m = y.length;
		System.out.println(countPairs(x, y, n, m));
	}
}
