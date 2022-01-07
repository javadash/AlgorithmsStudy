package chap1;

import java.util.Arrays;

public class CheckPermutation {
	static boolean isPermutation (String aStr, String bStr) {
		if(aStr.length() != bStr.length()) {
			return false;
		}
		char[] arrChar = aStr.toCharArray();
		char[] brrChar = bStr.toCharArray();
		Arrays.sort(arrChar);
		Arrays.sort(brrChar);
		
		for(int i = 0; i < aStr.length(); i++) {
			if(arrChar[i] != brrChar[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	static String sortString (String testStr) {
		char[] chars = testStr.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	

}
