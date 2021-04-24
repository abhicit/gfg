package com.gfg.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeThreeSortedArray {
	static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            if(A[i] < B[j]){
                list.add(A[i]);
                i++;
            }else if(A[i] > B[j]){
                list.add(B[j]);
                j++;
            }else{
                list.add(A[i]);
                list.add(B[j]);
                i++;
                j++;
            }
        }
        while(i < A.length){
            list.add(A[i]);
            i++;
        }
        while(j < B.length){
            list.add(B[j]);
            j++;
        }
        i = 0; j = 0;
        while(i < C.length && j < list.size()){
            if(C[i] <= list.get(j)){
                list.add(j, C[i]);
                i++;
                j++;
            }else
            	j++;
        }
        while(i < C.length){
            list.add(C[i]);
            i++;
        }
        return list;
    }
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[] B = {1, 2, 3, 4, 5};
		int[] C = {1, 2, 3, 4, 5, 6};
		ArrayList<Integer> list = merge3sorted(A, B, C);
		for(int i : list)
			System.out.print(i+" ");
	}
}
