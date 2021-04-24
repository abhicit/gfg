package com.gfg.strings;

public class FirstLeftRepeatingCharacter {
	static int repeatedCharacter(String S)
    {
        int[] freq = new int[256];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i++){
            if(freq[S.charAt(i)] != 0)
                res = Math.min(freq[S.charAt(i)]-1, res);
            freq[S.charAt(i)] = i+1;
        }
        return (res < 0 || res == Integer.MAX_VALUE) ? -1 : res;
    }
	
	public static void main(String[] args) {
		String S = "mtlwABMTirpNCOOrMlUVNMuhGxtfiJWNqEcgUUEYWuOUfgwQjPlFYgxYmSkWEYNIeAPismVyBKwgQbAkbgfvFGxtAfUxKVvUdrqsTpNeqRtJjCCdXPVbjKffUdiDWDGyHORsamWHtCJxe";
		System.out.println(S.charAt(repeatedCharacter(S)));
	}
}
