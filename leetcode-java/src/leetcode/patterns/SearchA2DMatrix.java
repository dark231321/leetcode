package leetcode.patterns;


/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * */
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            var mid = left + (right - left) /2;

            var first = mid/matrix[0].length;
            var second = mid%matrix[0].length;

            if (matrix[first][second] == target) {
                return true;
            }

            if (matrix[first][second] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{21,21,21,21},{23,30,34,60}}, 11));
        System.out.println(searchMatrix(new int[][]{{1,1}}, 1));
    }
}
