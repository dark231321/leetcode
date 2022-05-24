package leetcode.patterns;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        var m1 = Integer.MAX_VALUE;
        var m2 = Integer.MAX_VALUE;
        for (var num: nums) {
            if (m1 > num) {
                m1 = num;
            } else if (m2 > num) {
                m2 = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        increasingTriplet(new int[]{5, 4, 3, 2, 1});
    }
}
