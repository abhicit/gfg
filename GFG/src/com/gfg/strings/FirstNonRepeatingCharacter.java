package com.gfg.strings;

import java.util.Arrays;

public class FirstNonRepeatingCharacter {
	static char nonrepeatingCharacter(String S)
    {
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        char res = '$';
        for(int i = 0; i < S.length(); i++){
            if(freq[S.charAt(i)] != -1) {
            	freq[S.charAt(i)] = -2;
            	continue;
            }
            freq[S.charAt(i)] = i;
        }
        
        for(int i = 0; i < S.length(); i++){
        	if(freq[S.charAt(i)] != -1 && freq[S.charAt(i)] != -2){
                res = S.charAt(i);
                break;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String S = "zxvczbtxyzvy";
		System.out.println(nonrepeatingCharacter(S));
	}
}
