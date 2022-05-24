package leetcode.other.arrays;

public class ZeroMatrix {

    public static int[][] zeroMatrix(int[][] matrix) {
        boolean row[] = new boolean[matrix.length];
        boolean col[] = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (col[i]) nullifyColumn(matrix, i);
        }
        return matrix;
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    /**
     * 0 1 1    0 0 0
     * 1 2 3 -> 0 2 0
     * 1 2 0    0 0 0
     * */
    public static void main(String[] args) {

    }
}
