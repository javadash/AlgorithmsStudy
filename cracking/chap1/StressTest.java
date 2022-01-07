package chap1;

public class StressTest {
	static String createRandomString (int maxStrLen) {
		int lenOfString = (int)(2 + Math.random() * (maxStrLen - 2));
		String randomString = "";
		for(int i = 0; i < lenOfString; i++) {
			int aNumber = (int) ((int)48 + (Math.random() * 83));
			char aRandomChar = (char) aNumber;
			randomString += aRandomChar;
		}
		return randomString;
	}
	
	static void testUniqueString (int lenOfString) {
		if (lenOfString >= 2) {
			String testString = createRandomString(lenOfString);
			boolean result1 = UniqueString.isUniqueStringMap(testString);
			boolean result2 = UniqueString.isUniqueStringSorted(testString);
			
			if (result1 == result2) {
				System.out.println("Correct");
				
			} else {
				System.out.println("Wrong result" + result1 + " != " + result2);
			}
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			int lenOfString = (int) (2 + Math.random() * 30);
			testUniqueString(lenOfString);
		}
	}
}
