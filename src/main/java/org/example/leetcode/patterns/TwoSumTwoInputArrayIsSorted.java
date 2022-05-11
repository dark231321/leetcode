package org.example.leetcode.patterns;

import java.util.Arrays;

public class TwoSumTwoInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        var res = new int[2];
        var start = 0;
        var end = numbers.length - 1;
        while (end > start) {
            var tmpSum = numbers[end] + numbers[start];
            if (tmpSum == target) {
                res[0] = start + 1; res[1] = end + 1;
                return res;
            }
            if (tmpSum > target) {
                end--;
            }else {
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var twoSumTwoInputArrayIsSorted = new TwoSumTwoInputArrayIsSorted();
        System.out.println(Arrays.toString(twoSumTwoInputArrayIsSorted.twoSum(new int[]{5,25,75}, 100)));
    }
}
