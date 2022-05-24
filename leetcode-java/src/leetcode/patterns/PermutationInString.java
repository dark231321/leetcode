package leetcode.patterns;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {


    /**
     *
     * dd
     * rroogzkdktk
     * 0 1 2 3 4 5
     * 0 0 0 2 0 0
     * 0 1 2 3 4
     * 2 1 0 0 0
     * */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        var count = new int[26];
        var s1Chars = s1.toCharArray();
        var counter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (count[s1Chars[i] - 'a'] == 0) {
                counter++;
            }
            count[s1Chars[i] - 'a'] += 1;
        }

        var s2Chars = s2.toCharArray();
        for (int left = 0, right = 0; right < s2.length(); right++) {
            var tmp = s2Chars[right];
            count[tmp - 'a']--;
            if (count[tmp - 'a'] == 0) {
                counter--;
            }

            while (counter <= 0) {
                var charTmp = s2Chars[left];
                ++count[charTmp - 'a'];
                if (count[charTmp - 'a'] > 0) {
                    counter++;
                }

                if (right - left + 1 == s1.length()) {
                    return true;
                }
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ad", "drrrada"));
    }
}
