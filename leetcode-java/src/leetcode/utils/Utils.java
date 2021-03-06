package leetcode.utils;

import java.util.Objects;

public class Utils {

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public static Integer a = 1;

    public static ListNode randomLinkedListNode(int size, int min, int max) {
        ListNode first = new ListNode(randomIntInRange(min, max));
        ListNode last = first;
        for (int i = 1; i < size; i++) {
            ListNode tmp = new ListNode(null, last, randomIntInRange(min, max));
            last.setNext(tmp);
            last = tmp;
        }

        return first;
    }

    public static void print(ListNode listNode) {
        ListNode tmp = listNode;
        while (Objects.nonNull(tmp)) {
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}
