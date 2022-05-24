package leetcode.patterns;

import java.util.ArrayList;
import java.util.List;

public class SortedInteger {

    public static List<Integer> foo(List<Integer> ints) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < ints.size(); i++) {
            if ((i & 1) == (ints.get(i) & 1)) {
                res.add(ints.get(i));
            }
        }
        if (res.size() != 2) {
            if (res.isEmpty() && ints.size() >= 3) {
                return List.of(ints.get(0), ints.get(2));
            }
            return List.of(-1, -1);
        }
        return List.of(res.get(1), res.get(0));
    }

    public static void main(String[] args) {
        System.out.println(foo(List.of(2, 1, 3)));
    }
}
