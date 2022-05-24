package leetcode.patterns;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    /**
     * [[1,2],[2,3],[3,4],[1,3]] -> [1, 3] remove
     * [[1,2],[4,5],[5,7],[1,3][3,5]]
     * */

    public static int eraseOverlapIntervals(int[][] intervals) {
        int remove = 0;
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        var fi = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (isLess(fi, intervals[i])) {
                remove++;
                if (fi[1] > intervals[i][1]) {
                    fi = intervals[i];
                }
            } else {
                fi = intervals[i];
            }
        }
        return remove;
    }

    public static boolean isLess(int[] fi, int[] se) {
        return se[0] < fi[1];
    }

    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{new int[]{1, 2}, new int[]{1, 5}, new int[] {2, 3}});
    }
}
