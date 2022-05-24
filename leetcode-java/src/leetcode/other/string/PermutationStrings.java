package leetcode.other.string;

import java.util.Arrays;

public class PermutationStrings {

    public static boolean isPermutationsStrings(String first, String sec) {
        if (first.length() != sec.length()) {
            return false;
        }

        char[] firstArr = first.toCharArray();
        char[] secArr = sec.toCharArray();
        Arrays.sort(firstArr);
        Arrays.sort(secArr);

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] != secArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationsStrings("First", "tsriF"));
        System.out.println(isPermutationsStrings("Fi", "tsriF"));
        System.out.println(isPermutationsStrings("Fi", "tsriF"));
    }
}
