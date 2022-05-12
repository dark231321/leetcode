package org.example.leetcode.patterns;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    /**
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * */
    public static Queue<int[]> dexter(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return queue;
    }

    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};

    public static int[][] updateMatrix(int[][] mat) {
        var queue = dexter(mat);
        int r = mat.length;
        int c = mat[0].length;
        while (!queue.isEmpty()) {
            var tmp = queue.poll();
            for (var dirTmp: dir) {
                int x = tmp[0] + dirTmp[0];
                int y = tmp[1] + dirTmp[1];
                if (x < 0 || y < 0 || x >= r || y >= c || mat[x][y] <= mat[tmp[0]][tmp[1]] + 1) {
                    continue;
                }
                queue.add(new int[]{x, y});
                mat[x][y] = mat[tmp[0]][tmp[1]] + 1;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0,1}, {1,1}})));
    }
}
