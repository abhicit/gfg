package com.gfg.bitManipulation;

public class BinaryConversion {
	
	public static String toBinary(int N) {
        if(N <= 1) {
        	return "1";
        }
        
        return toBinary(N/2)+(N%2);
	}
	
	public static void main(String[] args) {
		System.out.println(toBinary(7));
	}
}
