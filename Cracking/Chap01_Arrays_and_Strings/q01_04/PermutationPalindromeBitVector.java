package Chap01_Arrays_and_Strings.q01_04;

public class PermutationPalindromeBitVector {
    //Toggle the ith bit in the integer
    public static int toggle (int bitVector, int index) {
        if(index < 0) return bitVector;
        int mask = 1 << index;
        if((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= mask;
        }
        return bitVector;
    }

    //Create bitVector for String. For each character with value i toggle the ith bit
    public static int createBitVector (String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = Character.getNumericValue(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    // Check that at most one bit is set by subtracting one from the integer/bitVector and ANDing it with the bitvector
    public static boolean checkAtMostOneBitSet (int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPermutationOfPalindrome (String phrase) {
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }
}
