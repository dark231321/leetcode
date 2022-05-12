package org.example.leetcode.patterns;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static class Data {
        public Queue<int[]> queue;
        public int count;

        public Data(Queue<int[]> queue, int count) {
            this.queue = queue;
            this.count = count;
        }
    }

    public static Data prepareToRotting(int[][] grid, int r, int c) {
        var qu = new LinkedList<int[]>();
        var count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    qu.add(new int[]{i, j});
                }
            }
        }
        return new Data(qu, count);
    }

    public static int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        var qu = prepareToRotting(grid, r, c);
        var iter = 0;
        while (!qu.queue.isEmpty() && qu.count != 0) {
            var size = qu.queue.size();
            while (size-- > 0) {
                var tmp = qu.queue.poll();
                for (var d: dir) {
                    int x = d[0] + tmp[0];
                    int y = d[1] + tmp[1];
                    if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    qu.queue.add(new int[]{x, y});
                    qu.count--;
                }
            }
            iter++;
        }

        if (qu.count != 0) {
            return -1;
        }
        return iter;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1}, {1,1,0}, {0,0,1}}));
    }
}
