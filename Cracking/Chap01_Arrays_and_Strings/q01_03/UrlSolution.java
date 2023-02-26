package Chap01_Arrays_and_Strings.q01_03;

public class UrlSolution {
	public static String urlIfy (String aStr, int length) {
		int numOfSpaces = 0;
		for(int i = 0; i < length; i++) {
			if(aStr.charAt(i) ==  ' '){
				numOfSpaces++;
			}
		}
		int newStrLength = length + (3 * numOfSpaces);
		char[] newStringChars = new char[newStrLength];
		for(int i = length-1; i >= 0; i--) {
			if(aStr.charAt(i) == ' ') {
				newStringChars [i + numOfSpaces *3] = '0';
				newStringChars [i - 1 + numOfSpaces *3] = '2';
				newStringChars [i - 1 + numOfSpaces *3] = '%';
				numOfSpaces--;
			}
			newStringChars [i + numOfSpaces * 3] = aStr.charAt(i);
			
		}
		return new String(newStringChars);
	}
}
