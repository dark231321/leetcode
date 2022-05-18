package org.example.leetcode.patterns;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    private static int findFist(int[] nums, int start, int end, int target) {
        while (start <= end) {
            var mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == 0 || target > nums[mid - 1])) {
                return  mid;
            }
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start >= nums.length || nums[start] != target) {
            return -1;
        }
        return start;
    }

    private static int findLast(int[] nums, int start, int end, int target) {
        while (start <= end) {
            var mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == nums.length - 1 || target < nums[mid + 1])) {
                return  mid;
            }
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start >= nums.length || nums[start] != target) {
            return -1;
        }
        return start;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[] {
                findFist(nums, 0, nums.length - 1, target),
                findLast(nums, 0, nums.length - 1, target),
        };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{0, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8}, 1)));
    }
}
