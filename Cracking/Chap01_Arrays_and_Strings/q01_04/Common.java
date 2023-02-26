package Chap01_Arrays_and_Strings.q01_04;

public class Common {
    public static int getCharNumber (Character c) {
        int value = Character.getNumericValue(c);
        if((int)'a' <= value && value <= (int)'z') return value - (int) 'a';
        return -1;
    }

    public static int[] buildCharFrequencyTable (String phrase) {
        int[] table = new int[26];
        for (Character c : phrase.toCharArray()) {
            int num = getCharNumber(c);
            if(num != -1) {
                table[num]++;
            }
        }
        return table;
    }
}
