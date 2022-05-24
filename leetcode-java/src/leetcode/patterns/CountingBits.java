package leetcode.patterns;

import java.util.Arrays;

public class CountingBits {
    //      00
    // 0 -> 0 -> 0
    //      01
    // 1 -> 1 -> 1
    //      01
    // 2 -> 10 -> 1
    //      10
    // 3 -> 11 -> 2
    //      001
    // 4 -> 100 -> 1
    //      010
    // 5 -> 101 -> 2
    //      010
    // 6 -> 110 -> 2
    // 7 -> 111 -> 3  111 % 2 = 1 111 >> 1 -> 011(3)
    // 8 -> 1000
    //
    private static int[] countBits(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = memo[i >> 1] + i % 2;
        }
        return memo;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(8)));
    }
}
