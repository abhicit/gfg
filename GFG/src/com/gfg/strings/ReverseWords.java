package com.gfg.strings;

public class ReverseWords {
	static String reverseWords(String S) {
        String[] str = S.split("\\.");
        StringBuilder res = new StringBuilder("");
        for(int i = str.length-1; i >= 0; i--){
            if(i == 0)
                res.append(str[i]);
            else
                res.append(str[i]).append(".");
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		String S = "i.like.this.program.very.much";
		System.out.println(reverseWords(S));
	}
}
