package org.example.leetcode.patterns;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num: nums) {
            if (integerSet.contains(num)) {
                return true;
            }
            integerSet.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3}));
    }
}
