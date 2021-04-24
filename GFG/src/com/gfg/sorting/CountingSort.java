package com.gfg.sorting;

import java.util.Arrays;

public class CountingSort {
	public static char[] countSort(char seq[])
    {
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, 0);
        for(int i = 0; i < seq.length; i++){
            alphabets[seq[i] - 'a']++;
        }
        for(int i = 1; i < 26; i++){
            alphabets[i] = alphabets[i] + alphabets[i-1];
        }
        char[] output = new char[seq.length];
        for(int i = seq.length-1; i >= 0; i--){
            output[alphabets[seq[i]-'a']-1] = seq[i];
            alphabets[seq[i]-'a']--;
        }
        for(int i = 0; i < seq.length; i++){
            seq[i] = output[i];
        }
        return seq;
    }
	
	public static void main(String[] args) {
		String str= "edsab";
		char[] alpha = countSort(str.toCharArray());
		for(char i : alpha)
			System.out.print(i);
	}
}
