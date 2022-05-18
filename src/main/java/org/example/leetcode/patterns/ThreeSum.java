package org.example.leetcode.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    /**
     * -1,0,1,2,-1,-4
     * -4 -1 -1 0 1 2
     *
     *
     * -3 -1 0 1 2
     * left + right = x > 0 :
     *               x + [left + 1]
     *               x + [right - 1]
     * if x == 0:
     *
     *
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++; r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{3,0,-2,-1,1,2}));
    }
}
