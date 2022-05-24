package leetcode.patterns;

public class NumberOfOneBits {

    public static int hammingWeight(int n) {
        var res = 0;
        for (int i = 0; i < 32 || n != 0; i++) {
            res = ((n & 1) == 1) ? res + 1: res;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(4));
    }
}
