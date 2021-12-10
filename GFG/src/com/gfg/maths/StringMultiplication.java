package com.gfg.maths;

public class StringMultiplication {
	public static void main(String[] args) {
		String num1 = "1235421415454545454545454544";
		String num2 = "1714546546546545454544548544544545";
		System.out.println(multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {
		String res = new String();
		String tempnum1 = num1;
		String tempnum2 = num2;
		if (num1.charAt(0) == '-'
				&& num2.charAt(0) != '-') {
			num1 = num1.substring(1);
		}
		else if (num1.charAt(0) != '-'
				&& num2.charAt(0) == '-') {
			num2 = num2.substring(1);
		}
		else if (num1.charAt(0) == '-'
				&& num2.charAt(0) == '-') {
			num1 = num1.substring(1);
			num2 = num2.substring(1);
		}
		String s1 = new StringBuffer(num1).reverse().toString();
		String s2 = new StringBuffer(num2).reverse().toString();

		int[] m = new int[s1.length() + s2.length()];
		
		for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                m[i + j] = m[i + j] + (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }
		
		for (int i = 0; i < m.length; i++) {
            int digit = m[i] % 10;
            int carry = m[i] / 10;
            if (i + 1 < m.length) {
                m[i + 1] = m[i + 1] + carry;
            }
            res = digit + res;
        }
		
		while (res.length() > 1
	               && res.charAt(0) == '0') {
	            res = res.substring(1);
	        }
	 
	        // Check condition if one string is negative
	        if (tempnum1.charAt(0) == '-'
	            && tempnum2.charAt(0) != '-') {
	            res = new StringBuffer(res)
	                          .insert(0, '-')
	                          .toString();
	        }
	        else if (tempnum1.charAt(0) != '-'
	                 && tempnum2.charAt(0) == '-') {
	            res = new StringBuffer(res)
	                          .insert(0, '-')
	                          .toString();
	        }
	        else if (tempnum1.charAt(0) == '-'
	                 && tempnum2.charAt(0) == '-') {
	            res = res;
	        }
		
		return res;
	}
}
