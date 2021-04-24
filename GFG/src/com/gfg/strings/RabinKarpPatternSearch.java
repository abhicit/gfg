package com.gfg.strings;

public class RabinKarpPatternSearch {
	
	public static void main(String[] args) {
		String txt = "aabaacaadaabaaba";//"abdscabcsjlacbabc";
		String pat = "aaba";
		
		RBSearch(txt, pat);
		System.out.println(search(pat, txt, 101));
	}
	
	static boolean search(String pat, String txt, int q)
    {
		int d= 256;
        if(pat.length() < txt.length())
            return false;
            
        int h = 1;
        for(int i = 0; i < pat.length()-1; i++)
            h = (h*d)%q;
        int t = 0, p = 0;
        for(int i = 0; i < pat.length(); i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + txt.charAt(i))%q;
        }
        int i = 0, j = 0;
        for(i = 0; i <= txt.length() - pat.length(); i++){
            if(t == p){
                for(j = 0; j < pat.length(); j++){
                    if(txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
                
                if(j == pat.length())
                    return true;
            }
            
            if(i < txt.length() - pat.length()){
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+pat.length()))%q;
                
                if(t < 0)
                    t = t + q;
            }
        }
        return false;
    }

	public static void RBSearch(String txt, String pat) {
		int h = 1;
		int d = 26;
		int n = txt.length();
		int m = pat.length();
		int q = 101;
		for(int i = 0; i < m-1; i++)
			h = (h*d)%q;
		
		int t = 0, p = 0;
		for(int i = 0; i < m; i++) {
			p = (p*d + pat.charAt(i))%q;
			t = (t*d + txt.charAt(i))%q;
		}
		
		int i;
		for(i = 0; i <= n-m; i++) {
			if(p == t) {
				int j;
				for(j = 0; j < m; j++) {
					if(txt.charAt(i+j) != pat.charAt(j))
						break;
				}
				
				if(j == m)
					System.out.println(i+" ");
			}
				if(i < n-m) {
					t = (d*(t-txt.charAt(i)*h)+txt.charAt(i+m))%q;
					
					if(t < 0)
						t = t+q;
				}
			}
		
	}
	
}
