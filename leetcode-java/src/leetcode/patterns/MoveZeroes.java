package leetcode.patterns;

import java.util.Arrays;

public class MoveZeroes {

    /**
     * -4 -3 0 1
     * 25 9 0 1 16
     * 16 9 0 1 25
     * 1  9 0 16 25
     *             |  |
     * 1 2 3 0 0 0 15 16 0
     * [0,1,2,2,0,3,12]
     * [12,1,2,2,0,3,0]
     *      |
     * [0,3,0,1,12]
     *    |    |
     * [0,3,12,1,0]
     * [12,1,0,3,0]
     *  |      |
     * [1,3,12,0,0]
     * [12,1,0,3,0]
     * [1,3,12,0,0]
     *
     *    ; ; ; |
     * [0,1,2,0,0,3,12]
     *
     * [0,1,2,0,0,3,12]
     *
     * [0,1,2,0,0,3,12]
     * 3 1 0 12 0
     */
    public void moveZeroes(int[] nums) {
        var lastNonNullIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                swap(nums, lastNonNullIndex ++, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        var moveZeroes = new MoveZeroes();
        var res = new int[] {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(res);
        System.out.println(Arrays.toString(res));
    }
}
