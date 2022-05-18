package org.example.leetcode.patterns;

public class SearchInRotatedSortedArray {

    /**
     * 4 5 6 7 0 1 2
     *
     * */
    public static int search(int[] nums, int target) {
        if (nums[nums.length - 1] == target) return nums.length - 1;
        if (nums[0] == target) return 0;
        var start = 0;
        var end = nums.length - 1;
        while (start <= end) {
            var mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // if sorted right 5 6 0 1 2 search 6
            if (nums[end] >= nums[mid]) {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int recursiveSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        var mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] <= nums[end]) {
            if (nums[mid] < target && target <= nums[end]) {
                return recursiveSearch(nums, mid + 1, end, target);
            }
            return recursiveSearch(nums, start, mid - 1, target);
        }
        if (nums[start] <= target && target < nums[mid]) {
            return recursiveSearch(nums, start, mid - 1, target);
        }
        return recursiveSearch(nums, mid + 1, end, target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var fi = mid/matrix.length;
            var se = mid%matrix[fi].length;
            if(matrix[fi][se] == target) {
                return true;
            }

            if(matrix[fi][se] > target) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 4));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 5));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 6));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 7));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 0));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 1));
        System.out.println(recursiveSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 6, 2));
    }
}
