package com.gfg.matrix;

import java.util.ArrayList;

public class SumOfUpperAndLowerTriangle {
	static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int upperTriangle = 0;
        int lowerTriangle = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                upperTriangle += matrix[i][j];
            }
        }
        res.add(upperTriangle);
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                lowerTriangle += matrix[i][j];
            }
        }
        res.add(lowerTriangle);
        return res;
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{6,5,4}, {1,2,5}, {7,9,7}};
		int n = 3;
		ArrayList<Integer> list = sumTriangles(matrix, n);
		for(int i : list)
			System.out.print(i+" ");
	}
}
