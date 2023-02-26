package Chap01_Arrays_and_Strings.q01_04;

public class PermutationPalindrome {
    public static boolean isPermutationPOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int [Character.getNumericValue('z') - Character.getNumericValue('z') + 1];
        for (Character c : phrase.toCharArray()) {
            int num = Common.getCharNumber(c);
            if(num != -1) {
                table [num]++;
                if(table[num] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
}
