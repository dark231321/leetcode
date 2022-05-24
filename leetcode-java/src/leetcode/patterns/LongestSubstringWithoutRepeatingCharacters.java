package leetcode.patterns;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int tmpMax = 0;
        for (int i = 0; i < s.length(); i++) {
            var set = new HashSet<Character>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    tmpMax++;
                    set.add(s.charAt(j));
                }
            }
            if (tmpMax > res) {
                res = tmpMax;
            }
            tmpMax = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
