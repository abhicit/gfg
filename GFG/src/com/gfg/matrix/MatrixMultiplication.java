package com.gfg.matrix;

public class MatrixMultiplication {
	static int[][] multiplyMatrix(int A[][], int B[][])
    {
        int[][] res = new int[A.length][B[0].length];
        if(A[0].length == B.length){
            for(int i = 0; i < A.length; i++){
                for(int j = 0; j < B[0].length; j++){
                    res[i][j] = A[i][j]*B[i][j] + A[j][i]*B[i+1][i];
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[][] A = {{4, 8}, {0, 2}, {1, 6}};
		int[][] B = {{5, 2}, {9, 4}};
		int[][] res = multiplyMatrix(A, B);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[i].length; j++)
				System.out.print(i+" ");
		}
	}
}
