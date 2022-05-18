package org.example.leetcode.patterns;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return ((n - 1) & n) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-8));
    }
}
