package com.gfg.strings;

public class SmallestWindowContainingGivenString {
	
	static final int no_of_chars = 256;
	 
    // Function to find smallest 
    // window containing
    // all characters of 'pat'
    static String findSubString(String str, String pat)
    {
        int len1 = str.length();
        int len2 = pat.length();
 
        // Check if string's length is 
        // less than pattern's
        // length. If yes then no such 
        // window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }
 
        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];
 
        // Store occurrence ofs 
        // characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;
 
        int start = 0, start_index = -1,
            min_len = Integer.MAX_VALUE;
 
        // Start traversing the string
        // Count of characters
        int count = 0; 
        for (int j = 0; j < len1; j++) {
           
            // Count occurrence of characters 
            // of string
            hash_str[str.charAt(j)]++;
 
            // If string's char matches 
            // with pattern's char
            // then increment count
            if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                count++;
 
            // If all the characters are matched
            if (count == len2) {
               
                // Try to minimize the window
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {
 
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }
 
                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }
 
        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }
 
        // Return substring starting 
        // from start_index
        // and length min_len
        return str.substring(start_index,
                             start_index + min_len);
    }
    
    
    public static String smallestWindow(String s, String p){
        if(s.length() < p.length())
            return "-1";
        
        int len1 = s.length();
        int len2 = p.length();
        
        int[] s_freq = new int[256];
        int[] p_freq = new int[256];
        
        for(int i = 0; i < len2; i++)
            p_freq[s.charAt(i)]++;
            
        int count = 0, start = 0, start_idx = -1, min_len = Integer.MAX_VALUE;
        
        for(int j = 0; j < len1; j++){
            s_freq[s.charAt(j)]++;
            
            if(s_freq[s.charAt(j)] <= p_freq[s.charAt(j)])
                count++;
                
            if(count == len2){
                while(s_freq[s.charAt(start)] > p_freq[s.charAt(start)] || p_freq[s.charAt(start)] == 0){
                    if(s_freq[s.charAt(start)] > p_freq[s.charAt(start)])
                        s_freq[s.charAt(start)]--;
                    start++;
                }
                
                if(min_len > j-start+1){
                    min_len = j-start+1;
                    start_idx = start;
                }
            }
        }
        
        return (start_idx == -1) ? "-1" : s.substring(start_idx, start_idx+min_len);
    }
 
    // Driver Method
    public static void main(String[] args)
    {
        String str = "timetopractice";
        String pat = "toc";
        System.out.println(smallestWindow(str, pat));
        //System.out.print("Smallest window is :\n " + findSubString(str, pat));
    }
	
}
