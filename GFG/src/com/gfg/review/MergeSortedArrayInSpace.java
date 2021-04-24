package com.gfg.review;

public class MergeSortedArrayInSpace {
	static void merge(int arr1[], int arr2[], int n, int m) { 
        
        int i=0,j=0,k=0;
        int maxm=Math.max(arr1[n-1],arr2[m-1])+1; // maximum element in both the arrays
        
        while(i<n && j<m){
            
            int curr1=arr1[i]%maxm; // original value stored at ith position in first array
            int curr2=arr2[j]%maxm; // original value stored at jth position in second array
            
            if(curr1>=curr2){
                
                if(k<n){
                    arr1[k]+=curr2*maxm;
                    j++;
                  }
                else{
                    arr2[k-n]+=curr2*maxm;
                    j++;
                  }
                 
            }
          else {
               
               if(k<n){
                   arr1[k]+=curr1*maxm;
                   i++;
               }
              else{
                  arr2[k-n]+=curr1*maxm;
                  i++;
              }
            }
           k++;
        }// end of while
        
      while(i<n){
          int curr1=arr1[i]%maxm;
          if(k<n)  arr1[k]+=curr1*maxm;
          else arr2[k-n]+=curr1*maxm;
          i++;k++;
      }
     while(j<m){
         int curr2=arr2[j]%maxm;
         if(k<n) arr1[k]+=curr2*maxm;
         else arr2[k-n]+=curr2*maxm;
         j++;k++;
     }
     
     for(int a=0;a<n;a++) arr1[a]/=maxm;
     for(int b=0;b<m;b++) arr2[b]/=maxm;
     
     for(int a : arr1)
    	 System.out.print(a+" ");
     System.out.println();
     for(int b : arr2)
    	 System.out.print(b+" ");
        
    }
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7, 9};
		int[] arr2 = {2, 4, 6 ,8, 10};
		merge(arr1, arr2, arr1.length, arr2.length);
	}
}
