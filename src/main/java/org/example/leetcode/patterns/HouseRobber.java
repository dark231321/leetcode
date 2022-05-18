package org.example.leetcode.patterns;

public class HouseRobber {

    /**
     *  4 2 2 4
     * [1, 2, 3, 4]
     *  1 -> 3 = 4
     *  2 -> 4 = 4
     *  1 -> 2
     *
     *  isLong = 0
     *  long_max = 2
     *  fast_max = 1
     *
     *  2 -> 3
     *  (max + 3) > (cur_max + 3):
     *      cur_max = max + 3
     *      max = cur_max + 3
     *  max
     * */
    public static int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 1? nums[0] : 0;
        }
        if (nums.length == 2) {
            return Math.max(nums[1], nums[0]);
        }
        var slow = nums[0];
        var fast = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            var tmp = fast;
            fast = Math.max(nums[i] + slow, fast);
            slow = tmp;
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{4, 2, 2, 4}));
    }
}
