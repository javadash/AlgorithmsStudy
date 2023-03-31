package Chap01_Arrays_and_Strings.q01_02;

import java.util.Arrays;

public class Solution0002_Permutation {

  public static String sortString(String testStr) {
    char[] chars = testStr.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static boolean isPermutation(String aStr, String bStr) {
    if (aStr.length() != bStr.length())
      return false;
    return sortString(aStr).equals(sortString(bStr));
  }

  public static boolean isPermutation_faster(String aStr, String bStr) {
    if (aStr.length() != bStr.length())
      return false;
    char[] chars = new char[128]; // assumption of only ascii characters
    for (char c : aStr.toCharArray()) {
      chars[c]++;
    }

    for (int i = 0; i < bStr.length(); i++) {
      int c = bStr.charAt(i);
      chars[c]--;
      if (chars[i] < 0) {
        return false;
      }
    }
    return true;
  }
}
