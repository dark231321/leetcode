package org.example.leetcode.patterns;

public class RangeSumQueryImmutable {
    static class NumArray {
        private final int[] sums;

        public NumArray(int[] nums) {
            this.sums = new int[nums.length];
            init(nums);
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sums[right];
            } else {
                return sums[right] - sums[left - 1];
            }
        }

        private void init(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }
    }

    public static void main(String[] args) {

        var i = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(i.sumRange(0, 2));
        System.out.println(i.sumRange(2, 5));
        System.out.println(i.sumRange(0, 5));
    }
}
