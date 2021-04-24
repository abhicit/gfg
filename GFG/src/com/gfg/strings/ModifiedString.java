package com.gfg.strings;

import java.util.HashMap;

public class ModifiedString {
	public static long modified(String a){
        int count = 1;
        long res = 0;
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        for(int i = 0; i < a.length(); i++)
            charFreq.put(a.charAt(i), charFreq.getOrDefault(a.charAt(i), 0)+1);
        int j = 0; 
        for(int i = 0; i < a.length(); i++){
            if(charFreq.get(a.charAt(i)) >= 3){
                j = i;
                while(j < a.length() && a.charAt(j) == a.charAt(i) && count < 3){
                    count++;
                    j++;
                }
                if(count == 3){
                    res++;
                }
                i = j-1;
                count = 0;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String a = "aaaaabbbbbv";
		System.out.println(modified(a));
	}
}
