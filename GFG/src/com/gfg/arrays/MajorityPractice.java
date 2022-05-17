package com.gfg.arrays;

public class MajorityPractice {
	public static void main(String[] args) {
		int n = 8;
		int[] arr = {5, 22, 29, 12, 32, 69, 1, 75};
		int x = 29;
		int y = 96;
		System.out.println(majorityWins(arr, n, x, y));
	}

	public static int majorityWins(int arr[], int n, int x, int y) {
        int xcount = 0;
        int ycount = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == x)
                xcount++;
            else if(arr[i] == y)
                ycount++;
        }
        
        if(xcount == 0 && ycount == 0)
            return (x < y) ? x : y;
        else
            return (xcount > ycount) ? xcount : ycount;
    }
}
