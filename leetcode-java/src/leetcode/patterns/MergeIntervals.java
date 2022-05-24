package leetcode.patterns;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class MergeIntervals {
    /**
     * [1, 3] [2, 6] [7, 10] [15, 18]
     *
     * */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        if (intervals.length == 0) {
            return new int[][]{};
        }

        if (intervals.length == 1) {
            return new int[][]{{intervals[0][0], intervals[0][1]}};
        }
        int first = intervals[0][0];
        int last = intervals[0][1];
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > last) {
                tmp.add(List.of(first, last));
                first = intervals[i][0];
            } else {
                if (intervals[i][0] < first) {
                    first = intervals[i][0];
                }
            }
            if (intervals[i][1] > last) {
                last = intervals[i][1];
            }
        }
        tmp.add(List.of(intervals[first][0], intervals[last][1]));
        var res = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i).get(0);
            res[i][1] = tmp.get(i).get(1);
        }
        return res;
    }

    public static int[][] mergeTmp(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for (var i: intervals) {
            if (res.isEmpty() || res.getLast()[1] < i[0]) {
                res.add(i);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], i[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    static class GraphSolution {
        private Map<int[], List<int[]>> graph;
        private Map<Integer, List<int[]>> nodesInComp;
        private Set<int[]> visited;

        private boolean overlap(int[] a, int[] b) {
            return a[0] <= b[1] && b[0] <= a[1];
        }

        private void buildGraph(int[][] intervals) {
            graph = new HashMap<>();
            for (int[] tmp: intervals) {
                graph.put(tmp, new LinkedList<>());
            }

            for (int[] tmp: intervals) {
                for (int[] internal: intervals) {
                    if (overlap(tmp, internal) && tmp != internal) {
                        graph.get(internal).add(tmp);
                        graph.get(tmp).add(internal);
                    }
                }
            }
        }

        private void markComponentDFS(int[] start, int compNumber) {
            Deque<int[]> stack = new ArrayDeque<>();
            stack.add(start);
            while (!stack.isEmpty()) {
                int[] node = stack.pop();
                if (!visited.contains(node)) {
                    visited.add(node);
                    nodesInComp.computeIfAbsent(compNumber, k -> new LinkedList<>());
                    nodesInComp.get(compNumber).add(node);
                    stack.addAll(graph.get(node));
                }
            }
        }

        private void compute(int[][] intervals) {
            visited = new HashSet<>();
            nodesInComp = new HashMap<>();
            int compNumber = 0;
            for (int[] tmp: intervals) {
                if (!visited.contains(tmp)) {
                    markComponentDFS(tmp, compNumber);
                    compNumber++;
                }
            }
        }

        private int[] mergeNodes(List<int[]> merged) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (var tmp: merged) {
                min = Math.min(min, tmp[0]);
                max = Math.max(max, tmp[1]);
            }
            return new int[]{min, max};
        }

        public int[][] merge(int[][] intervals) {
            buildGraph(intervals);
            compute(intervals);
            var res = new int[nodesInComp.size()][2];
            for (var node: nodesInComp.entrySet()) {
                res[node.getKey()] = mergeNodes(node.getValue());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        var graph = new GraphSolution();
        System.out.println(Arrays.deepToString(graph.merge(new int[][]{{1, 3}, {2, 4}, {2, 2}, {6, 8}, {7, 10}, {15, 18}})));
    }
}
