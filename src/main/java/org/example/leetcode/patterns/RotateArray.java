package org.example.leetcode.patterns;

import java.util.Arrays;

public class RotateArray {

    /**
     * nums: [7,1,2,3,4,5,6]
     * k:    3
     *
     *       [4,5,6,7,1,2,3]
     * nums: [7,1,2,3,4,5,6]
     * k:    4
     *        7 - 3 = 4 - 1
     *        0     3 4   6
     *       [6,5,4,3,2,1,7]
     *        0   2 3     6
     *       [3,4,5,6,7,1,2]
     *       [0,1,2,3,4,5,6]
     * */
    public void rotate(int[] nums, int k) {
        var uniqueRotate = k % nums.length;

        for (int i = 0; i < nums.length/2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }

        for (int i = 0; i < uniqueRotate/2; i++) {
            swap(nums, i, nums.length - (nums.length - uniqueRotate) - i - 1);
        }

        for (int i = uniqueRotate; i < (nums.length + uniqueRotate) / 2; i++) {
            swap(nums, i, nums.length - 1 - (i - uniqueRotate));
        }
    }

    private void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swapRotate(int[] nums, int start, int end) {
        while (start < end) {
            var tmp = nums[start];
            nums[start++]  = nums[end];
            nums[end--] = tmp;
        }
    }

    public void swapRotate(int[] nums, int k) {
        var unique = k % nums.length;
        swapRotate(nums, 0, nums.length - 1);
        swapRotate(nums, 0,  unique - 1);
        swapRotate(nums, unique,  nums.length - 1);
    }

    public static void main(String[] args) {
        var rotate = new RotateArray();
        var res = new int[]{7, 1, 2, 3, 4, 5, 6};
        rotate.swapRotate(res, 4);
        System.out.println(Arrays.toString(res));
    }
}
