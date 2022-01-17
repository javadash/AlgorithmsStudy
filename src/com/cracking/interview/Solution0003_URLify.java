package com.cracking.interview;

public class Solution0003_URLify {
	public static String URLify(String aStr, int trueLength) {
		int numOfSpaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if(aStr.charAt(i) == ' ') {
				numOfSpaces++;
			}
		}
		int strLen = trueLength + 2 * numOfSpaces;
		char[] strChars = new char[strLen];
		
		for(int i = trueLength - 1; i >= 0; i--) {
			if(aStr.charAt(i) == ' ' && numOfSpaces >= 0) {
				strChars[i + numOfSpaces * 2]  = '0';
				strChars[i - 1 + numOfSpaces * 2]  = '2';
				strChars[i - 2 + numOfSpaces * 2]  = '%';
				numOfSpaces--;
			} else {		
				if(numOfSpaces >= 0) {				
					strChars[i + numOfSpaces * 2]  = aStr.charAt(i);
				}
			}
		}
		return new String(strChars);
	}
	
	public static void main(String args []) {
		String aStr = "Lumumba shi azi ependa dongo kazuma         ";
		System.out.println(URLify(aStr, 35)); 
		
	}
}