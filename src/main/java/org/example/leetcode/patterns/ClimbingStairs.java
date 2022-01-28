package org.example.leetcode.patterns;

public class ClimbingStairs {
    // 2 - 2
    // 3 - 3
    // 4 - 5
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res1 = 1;
        int res2 = 2;
        for (int i = 2; i < n; i++) {
            int tmp = res1;
            res1 = res2;
            res2 = res2 + tmp;
        }
        return res2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
