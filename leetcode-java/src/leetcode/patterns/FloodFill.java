package leetcode.patterns;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class FloodFill {

    /**
     * 1 0 1 1
     * 0 1 1 0
     * 0 0 0 0
     * src      : 2
     * sc       : 1
     * newColor : 2
     * 1 0 1 1
     * 0 1 2 0
     * 0 0 0 0
     *
     * visited: [2,1]
     * stack:   [2,0], [1,1]
     * */
    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        if (image[x][y] == newColor) {
            return image;
        }

        floodFill(image, x, y, image[x][y], newColor);
        return image;
    }

    private static void floodFill(int[][] image, int x, int y, int color, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != color) {
            return;
        }
        image[x][y] = newColor;
        floodFill(image, x + 1, y, color, newColor);
        floodFill(image, x - 1, y, color, newColor);
        floodFill(image, x, y + 1, color, newColor);
        floodFill(image, x, y - 1, color, newColor);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0,0,1}, {0,0,1}}, 0, 0, 2)));
    }
}
