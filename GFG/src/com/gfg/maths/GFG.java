package com.gfg.maths;

class GFG 
{ 
	private static int gcd(int reduceNum, int b) 
    { 
        return b == 0 ?  
            reduceNum : gcd(b, reduceNum % b); 
    }
	
	private static int reduceB(int a, String b)  
    { 
        int result = 0; 
        for (int i = 0; i < b.length(); i++)  
        { 
            result = (result * 10 + 
                      b.charAt(i) - '0') % a; 
        } 
        return result; 
    }
	
	private static int gcdLarge(int a, String b)  
    { 
        // Reduce 'b' i.e the second  
        // number after modulo with a 
        int num = reduceB(a, b); 
          
        // Now,use the euclid's algorithm  
        // to find the gcd of the 2 numbers 
        return gcd(num, a); 
    } 
  
// Driver Program 
	public static void main(String[] args)  
    { 
        // First Number which 
        // is the integer 
        int a = 1221; 
          
        // Second Number is represented  
        // as a string because it cannot  
        // be represented as an integer 
        // data type 
        String b = "19837658191095787329"; 
        if (a == 0) 
            System.out.println(b); 
        else
            System.out.println(gcdLarge(a, b)); 
    } 
}