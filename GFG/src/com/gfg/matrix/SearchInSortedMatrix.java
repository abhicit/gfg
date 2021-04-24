package com.gfg.matrix;

public class SearchInSortedMatrix {
	public static void search(int[][] mat, int x) {//O(row + column)
		int i = 0, j = mat[0].length-1;
		while(i < mat.length && j >= 0) {
			if(mat[i][j] == x) {
				System.out.println("Found at ("+i+", "+j+")");
				return;
			}
			else if(mat[i][j] > x) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println("Not Found!");
	}
	
	public static void main(String[] args) {
		int[][] mat = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
		search(mat, 33);
	}
}
