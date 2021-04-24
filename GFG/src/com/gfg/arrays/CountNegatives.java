package com.gfg.arrays;

public class CountNegatives {
	public static int countNegatives(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            sum += getNegativeCntForRow(grid[i], 0, grid[i].length - 1);
        }
        return sum;
    }
	
	static int getNegativeCntForRow(int[] arr, int low, int high){
        if(arr[high] > 0 ) return 0;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] < 0){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }    
        }
        return arr.length - low;
    }
	
	public static void main(String[] args) {
		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		System.out.println(countNegatives(grid));
	}
}
