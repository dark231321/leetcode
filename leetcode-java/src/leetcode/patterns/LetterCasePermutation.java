package leetcode.patterns;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    /**
     * a1b2
     * A1b2
     *
     *
     * */
    public static List<String> letterCasePermutation(String s) {
        return letterCasePermutationRecursive(init(s), s, 0);
    }

    public static List<String> init(String s) {
        var res = new ArrayList<String>();
        res.add(s);
        return res;
    }

    public static List<String> letterCasePermutationRecursive(List<String> res, String s, int j) {
        for (int i = j; i < s.length(); i++) {
            var tmp = s.toCharArray();
            if (isLowerCase(tmp[i])) {
                tmp[i] = Character.toUpperCase(tmp[i]);
                toNextIter(tmp, i + 1, res);
            } else if (isUpperCase(tmp[i])) {
                tmp[i] = Character.toLowerCase(tmp[i]);
                toNextIter(tmp, i + 1, res);
            }
        }
        return res;
    }

    public static void toNextIter(char[] tmp, int i, List<String> res) {
        var tmpRes = new String(tmp);
        res.add(tmpRes);
        letterCasePermutationRecursive(res, tmpRes, i);
    }

    public static boolean isUpperCase(Character ch) {
        return 'A' <= ch && ch <= 'Z';
    }

    public static boolean isLowerCase(Character ch) {
        return 'a' <= ch && ch <= 'z';
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("po"));
    }
}
