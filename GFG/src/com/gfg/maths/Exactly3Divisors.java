package com.gfg.maths;

public class Exactly3Divisors {
	public static int exactly3Divisors(int N)
    {
        int count = 0;
        for(int i = 2; i*i <= N; i++){
            if(isPrime(i))
                if(i*i <= N)
                    count++;
        }
        return count;
    }
    
    public static boolean isPrime(int N){
        for(int i = 2; i*i <= N; i++){
            if(N%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(exactly3Divisors(100));
	}
}
