package org.example.leetcode.patterns;

import java.util.Arrays;

public class MaxAreaOfIsland {

    static class Int {
        public Integer count;

        public Int(Integer count) {
            this.count = count;
        }
    }

    /**
     * 0 1 0 0 0
     * 0 1 0 0 0
     * 0 0 1 1 0
     * 0 0 1 0 0
     * 0 0 0 0 0
     * */
    public static int maxAreaOfIsland(int[][] grid) {
        var res = 0;
        int lenY = grid[0].length, lenX = grid.length;
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                res = Math.max(res, searchArea(grid, i, j));
            }
        }
        return res;
    }

    public static int searchArea(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + searchArea(grid, x + 1, y) + searchArea(grid, x - 1, y) + searchArea(grid, x, y + 1) + searchArea(grid, x, y - 1);
    }


    public static int maxAreaOfIsland1(int[][] grid) {
        var visited = new int[grid.length][grid[0].length];
        return dfsGrid(grid, 0, 0, 0, visited);
    }

    public static int dfsGrid(int[][] grid, int x, int y, int count, int[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return count;
        }
        if (visited[x][y] != 0) {
            return visited[x][y];
        }

        count = grid[x][y] == 0 ? 0 : count + 1;

        count = Math.max(dfsGrid(grid, x + 1, y, count, visited), count);
        count = Math.max(dfsGrid(grid, x - 1, y, count, visited), count);
        count = Math.max(dfsGrid(grid, x, y + 1, count, visited), count);
        count = Math.max(dfsGrid(grid, x, y - 1, count, visited), count);
        visited[x][y] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{1,0,1}, {1,0,0}}));
    }
}
