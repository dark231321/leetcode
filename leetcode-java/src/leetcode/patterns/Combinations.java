package leetcode.patterns;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> tmp = new ArrayList<>();
        backtrack(tmp, new LinkedList<>(), n, k, 1);
        return tmp;
    }

    /**
     * 1 2 3 4
     * 1
     *   2
     * */
    public static List<List<Integer>> combineRecursive(List<List<Integer>> res, Deque<Integer> tmp, int n, int k, int i) {
        for (int j = i; j <= n; j++) {
            tmp.add(j);
            if (tmp.size() == k) {
                res.add(new ArrayList<>(tmp));
            } else {
                combineRecursive(res, tmp, n, k, j + 1);
            }
            tmp.pollLast();
        }
        return res;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int n, int k, int start){
        if(temp.size() == k) list.add(new LinkedList<>(temp));

        for(int i = start; i <= n; i++){
            temp.add(i);
            backtrack(list, temp, n, k, ++start);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
