package com.cracking.interview;
import java.util.*;

public class Solution0001_UniqueSting {
	static boolean isUniqueStringMap (String aStr) {
		Map<Character, Integer> charTable = new HashMap<Character, Integer>();
		boolean isUnique = true;
		for(char aCharacter :aStr.toCharArray()) {
			if(charTable.get(aCharacter) == null) {
				charTable.put(aCharacter, 1);
				
			} else if(charTable.get(aCharacter) == 1) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}
	
	static boolean isUniqueStringSorted (String aStr) {
		char[] chars = aStr.toCharArray();
		Arrays.sort(chars);
		boolean isUnique = true;
		for (int i = 0; i < chars.length - 1; i++) {
			if(chars[i] == chars[i+1]) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}
	
	public static void main(String[] args) {
		String testString = "abcde";
		for (int i = 0; i < testString.length(); i++){
		    char c = testString.charAt(i);
		}
		
	}
}
