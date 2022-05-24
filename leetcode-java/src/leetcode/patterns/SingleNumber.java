package leetcode.patterns;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int cur = 0;
        for (int i: nums) {
            cur ^= i;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,2,2,4}));
    }
}
