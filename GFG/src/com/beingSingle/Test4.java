package com.beingSingle;


public class Test4 {
	public static int[][] flipAndInvertImage(int[][] A) {
        
        for(int i = 0; i < A.length; i++){
        	int j = 0, k = A.length-1;
            while(j < k){
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
                j++;
                k--;
            }
        }
        
        for(int i = 0; i < A.length; i++){
            for(int l = 0; l < A[i].length; l++){
                if(A[i][l] == 0)
                    A[i][l] = 1;
                else
                    A[i][l] = 0;
            }
        }
        
        return A;
    }
	
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		int[][] res = flipAndInvertImage(arr);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
}
