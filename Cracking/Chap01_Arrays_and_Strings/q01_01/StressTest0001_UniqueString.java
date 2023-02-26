package Chap01_Arrays_and_Strings.q01_01;

public class StressTest0001_UniqueString {
	public static String createRandomString (int maxStringLen) {
		int lenOfString  = (int) (2 + Math.random() * (maxStringLen-2));
		String randomString = "";
		for (int i = 0; i < lenOfString; i++) {
			int aNumber = (int) (97 + Math.random() * 27);
			char aRandomChar = (char) aNumber;
			randomString += aRandomChar;
		}
		return randomString;
		
	}
	
	public static void testUniqueString (int lenOfString) {
		if(lenOfString >= 2) {
			String testString = createRandomString(lenOfString);
			System.out.println(testString);
			boolean result1 = Solution0001_UniqueSting.isUniqueStringMap(testString);
			boolean result2 = Solution0001_UniqueSting.isUniqueStringSorted(testString);
			if (result1 == result2) {
				System.out.println("Correct!: " + result1);
			} else {
				System.out.println("Wrong result: " + result1 + " " + result2);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			int lenOfString = (int) (2 + Math.random()*30);
			testUniqueString(lenOfString);
		}
	}
}
