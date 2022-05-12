package org.example.leetcode.patterns;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        int[] tmp = new int[26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            tmp[s.charAt(i) - 'a']++;
            queue.add(i);
        }
        for (var i: queue) {
            if (tmp[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("llettcode"));
    }
}
