package org.example.leetcode.patterns;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        var rows = new boolean[10][10];
        var col = new boolean[10][10];
        for (int k = 0; k < 3; k++) {
            for (int k1 = 0; k1 < 3; k1++) {
                int sum = 0;
                var tmp = new boolean[10];
                for (int i = 3 * k; i < 3 + 3 * k; i++) {
                    for (int j = 3 * k1; j < 3 + 3 * k1; j++) {
                        if (board[i][j] == '.') continue;

                        if (board[i][j] > '9' || board[i][j] < '0'
                                || rows[i][board[i][j] - '0']
                                || tmp[board[i][j] - '0']
                                || col[j][board[i][j] - '0']) {
                                return false;
                            }
                            tmp[board[i][j] - '0'] = true;
                            rows[i][board[i][j] - '0'] = true;
                            col[j][board[i][j] - '0'] = true;
                            sum += board[i][j] - '0';
                        }
                    }
                    if (sum > 45) {
                        return false;
                    }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});

        System.out.println('9' - '0');
    }
}