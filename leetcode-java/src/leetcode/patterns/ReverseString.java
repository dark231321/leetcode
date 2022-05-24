package leetcode.patterns;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int start = 0, end = s.length-1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
    }

    public void swap(char[] s, int i, int j) {
        var tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        var reverse = new ReverseString();
        var res = new char[]{'h','e','l','l','o'};
        reverse.reverseString(res);
        System.out.println(Arrays.toString(res));
    }
}
