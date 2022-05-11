package org.example.leetcode.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {


    /**
     *          1
     *        1   1
     *      1   2   1
     *    1   3   3   1
     *  1   4   6   4   1
     * */
    public static List<List<Integer>> generate(int numRows) {
        var res = new ArrayList<List<Integer>>(numRows);

        for (int i = 0; i < numRows; i++) {
            var tmp = new Integer[i + 1];
            tmp[0] = 1;
            tmp[i] = 1;
            for (int j = 1; j < i; j++) {
                tmp[j] = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
            }
            res.add(List.of(tmp));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
