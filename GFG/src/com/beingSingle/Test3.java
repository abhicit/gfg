package com.beingSingle;

public class Test3 {
	public static int diagonalSum(int[][] mat) {
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            res += mat[i][i];
        }
        int j = mat[0].length-1;
        int i = 0;
        while(i < mat[0].length && j >= 0){
            if(i != j){
                res += mat[i][j];
            }
            i++;
            j--;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[][] arr = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
		System.out.println(diagonalSum(arr));
	}
}
