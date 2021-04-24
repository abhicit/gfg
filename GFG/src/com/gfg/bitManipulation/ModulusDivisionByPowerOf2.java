package com.gfg.bitManipulation;

public class ModulusDivisionByPowerOf2 {
	
	public static int modulusDivisionByPowerOf2(int n, int d) {
		return n & (d-1);
	}
	
	public static void main(String[] args) {
		System.out.println(modulusDivisionByPowerOf2(7, 32));
	}
}
