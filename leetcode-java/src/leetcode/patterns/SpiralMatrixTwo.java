package leetcode.patterns;

import java.util.Arrays;

public class SpiralMatrixTwo {
    /**
     * 1 2 3
     * 8 9 4
     * 7 6 5
     * */
    public static int[][] generateMatrix(int n) {
        var res = new int[n][n];
        var col = 0;
        var row = 0;
        for (int i = 1; i <= n*n; col++, row++) {
            for (int j = row; j < n - col && i <= n*n; j++, i++) {
                res[row][j] = i;
            }
            for (int j = row + 1; j < n - row && i <= n*n; j++, i++) {
                res[j][n - col - 1] = i;
            }
            for (int j = (n - col - 2); j >= col && i <= n*n; j--, i++) {
                res[n - row - 1][j] = i;
            }
            for (int j = (n - row - 2); j > row && i <= n*n; j--, i++) {
                res[j][col] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(6)));
    }
}
