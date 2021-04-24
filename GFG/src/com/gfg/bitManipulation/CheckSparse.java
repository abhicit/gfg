package com.gfg.bitManipulation;

public class CheckSparse {
	public static boolean isSparse(int n){
        int count = 0;
        while(n != 0){
            if((n&1) == 1){
                count++;
                if(count > 1){
                    return false;
                }
            }else{
                if(count >= 1)
                    count--;
            }
            n >>= 1;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isSparse(41));
	}
}
