package org.example.leetcode.patterns;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 * */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        var res = new int[26];
        int left = 0, right = 0;
        while (left < ransomNote.length() && right < magazine.length()) {
            res[magazine.charAt(left) - 'a']++;
            res[ransomNote.charAt(left) - 'a']--;
            left++;
            right++;
        }
        var size = magazine.length() - ransomNote.length();
        while (size-- > 0) {
            res[magazine.charAt(magazine.length() - size - 1) - 'a']++;
        }
        for (int re : res) {
            if (re < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abbb", "aab"));
    }
}
