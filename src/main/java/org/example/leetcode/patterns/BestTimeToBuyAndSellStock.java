package org.example.leetcode.patterns;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    // [7,1,5,3,6,4] -> 7 - 1 = 6 1 - 5
    public static int maxProfit(int[] prices) {
        int max = 0;
        int bayed = prices[0];
        int cur;
        for (int i = 1; i < prices.length; i ++) {
            cur = prices[i] - bayed;
            if (cur > max) {
                max = cur;
            }
            bayed = Math.min(bayed, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
