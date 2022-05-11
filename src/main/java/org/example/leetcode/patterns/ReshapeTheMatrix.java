package org.example.leetcode.patterns;

import java.util.Arrays;

public class ReshapeTheMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length == 0 || mat.length * mat[0].length != r * c) return mat;

        var res = new int[r][c];
        for (int i = 0, k = 0, k1 = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++, k++) {
                if (k == c) {
                    k1++;
                    k = 0;
                }
                res[k1][k] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }
}
