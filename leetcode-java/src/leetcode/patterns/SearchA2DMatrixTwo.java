package leetcode.patterns;

public class SearchA2DMatrixTwo {

    /**
     * 1 2  3  4
     * 5 6  7  8
     * 9 10 11 12
     *
     * search 6
     * */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (var row: matrix) {
            if (searchMatrix(row, target)) return true;
        }
        return false;
    }

    public static boolean searchMatrix(int[] rows, int target) {
        var lower = 0;
        var high = rows.length - 1;
        while (lower <= high) {
            var mid = lower + (high - lower) / 2;
            if (rows[mid] == target) {
                return true;
            }
            if (rows[mid] > target) {
                high = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrixTwo(int[][] matrix, int target) {
        var n = matrix.length;
        var m = matrix[0].length;

        var i = 0;
        var j = matrix[0].length - 1;
        while (i < n && j >= 0) {
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target) {
                j--;
            } else if(matrix[i][j]<target) {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrixTwo(new int[][] {
                new int[]{1, 4},
                new int[]{2, 5}
        }, 6));
    }
}
