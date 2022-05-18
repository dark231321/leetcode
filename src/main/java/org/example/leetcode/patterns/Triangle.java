package org.example.leetcode.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        var res = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            var curSize = triangle.get(i).size() - 1;
            var prevSize = triangle.get(i - 1).size() - 1;
            triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            triangle.get(i).set(curSize, triangle.get(i - 1).get(prevSize) + triangle.get(i).get(curSize));
            res = triangle.get(i).get(0);
            res = Math.min(res, triangle.get(i).get(curSize));
            for (int j = 1; j < curSize; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                res = Math.min(res, triangle.get(i).get(j));
            }
        }
        triangle.forEach(System.out::println);
        return res;
    }

    /**
     *    2      ^
     *   3 4     |
     *  6 5 7    |
     * 4 1 8 3   |
     * */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        var res = Stream.of(
                Stream.of(2).collect(Collectors.toList()),
                Stream.of(3, 4).collect(Collectors.toList()),
                Stream.of(6, 5, 7).collect(Collectors.toList()),
                Stream.of(4, 1, 8, 3).collect(Collectors.toList())
        ).collect(Collectors.toList());
        System.out.println(minimumTotal1(res));
    }
}
