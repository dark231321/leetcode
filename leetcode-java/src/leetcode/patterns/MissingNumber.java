package leetcode.patterns;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

// 0000
// 0001
// 0010
// 0011
// 0100
// 0101
// 0110
// 0111
// ...
// 1111
public class MissingNumber {
    // 0 1 3
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int max = nums.length;
        for (int i: nums) {
            sum += i;
        }
        return (max) * (max + 1) / 2 - sum;

    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3}));
    }
}
