package com.gfg.strings;

public class Anagram {
	
	public static void main(String[] args) {
		String a = "geeksforgeeks";
		String b = "forgeeksgeeks";
		System.out.println(isAnagram(a, b));
	}

	public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length())
            return false;
            
        int[] temp = new int[256];
        for(int i = 0; i < a.length(); i++){
            temp[a.charAt(i)]++;
            temp[b.charAt(i)]--;
        }
        
        for(int i = 0; i < temp.length; i++)
            if(temp[i] != 0)
                return false;
        
        return true;
    }
	
}
