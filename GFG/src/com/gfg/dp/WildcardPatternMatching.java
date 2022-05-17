package com.gfg.dp;

public class WildcardPatternMatching {
	public static void main(String[] args) {
		System.out.println(wildCard("ba*a?", "baaabab"));
	}
	
	public static int wildCard(String pattern, String str)
    {
        int S = str.length(), P = pattern.length(), star_p = -1, star_s = 0;
        int s = 0, p = 0;
        
        while(s < S) {
            if(p < P && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
                s++;
                p++;
            }
            else if(p < P && pattern.charAt(p) == '*') {
                star_p = p;
                star_s = s; // Dont increment s '*' can match '' too
                p++;
            }
            else if(star_p != -1) {
                p = star_p + 1;
                s = star_s;
                star_s++;
            }
            else
                return 0;
        }
        
        while(p < P && pattern.charAt(p) == '*') p++;
        return (p == P) ? 1 : 0;
    }
}
