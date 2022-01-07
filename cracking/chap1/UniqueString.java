package chap1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqueString {
	static boolean isUniqueStringMap (String aStr) {
		Map<Character, Integer> charTable  = new HashMap<Character, Integer>();
		boolean isUnique = true;
		for(char aCharacter : aStr.toCharArray()) {
			if(charTable.get(aCharacter) ==  null) {
				charTable.put(aCharacter, 1);
			} else if (charTable.get(aCharacter) == 1) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	public static boolean isUniqueStringSorted(String aStr) {
		char[] chars = aStr.toCharArray();
		Arrays.sort(chars);
		String sortedStr = new String(chars);
		boolean isUnique = true;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == chars[i+1]) {
				isUnique = false;
				break;
			}
 		}
		return isUnique;
	}
	
	public static boolean isUniqueString (String aStr) {
		int checker = 0;
		for(int i = 0; i < aStr.length(); i++) {
			int value = aStr.charAt(i) - 'a';
			if ((checker & (1 << value)) > 0) {
				return false;
			}
			checker |= (i << value);
		}
		return true;
	}

}
