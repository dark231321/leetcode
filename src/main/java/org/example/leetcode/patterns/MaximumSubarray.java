package org.example.leetcode.patterns;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (nums[i] > cur) {
                cur = nums[i];
            }
            max = Math.max(cur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));
    }
}
