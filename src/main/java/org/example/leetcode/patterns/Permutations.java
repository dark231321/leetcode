package org.example.leetcode.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums, init(nums), 1);
    }

    public static List<List<Integer>> init(int[] nums) {
        var res = new ArrayList<List<Integer>>(size(nums.length));
        res.add(toList(nums));
        return res;
    }

    public static int size(int arrSize) {
        var res = 1;
        while (arrSize >= 2) {
            res *= arrSize;
            arrSize--;
        }
        return res;
    }

    /**
     * 1 2 3
     * 2 1 3
     * 3 2 1
     * */
    public static List<List<Integer>> permute(int[] nums, List<List<Integer>> res, int i) {
        for (int k = i; k < nums.length; k++) {
            var tmp = Arrays.copyOf(nums, nums.length);
            swap(tmp, i - 1, k);
            res.add(toList(tmp));
            permute(tmp, res, i + 1);
        }
        if (i + 1 < nums.length) {
            permute(nums, res, i + 1);
        }
        return res;
    }

    public static void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static List<Integer> toList(int[] nums) {
        var res = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        var res = permute(new int[]{1, 2, 3, 4});
        System.out.println(res);
        System.out.println(res.size());
    }
}
