package leetcode.patterns;

public class ReverseWordsInAStringThree {

    public String reverseWords(String s) {
        int start = 0;
        char[] res = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                reverseWord(res, start, i - 1);
                start = i + 1;
            }
        }
        reverseWord(res, start, s.length() - 1);
        return new String(res);
    }

    public void reverseWord(char[] res, int start, int end) {
        while (start < end) {
            swap(res, start, end);
            start++;
            end--;
        }
    }

    public void swap(char[] res, int i, int j) {
        var tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }

    public static void main(String[] args) {
        var tmp = new ReverseWordsInAStringThree();
        System.out.println(tmp.reverseWords("Let's take LeetCode contest"));

    }
}
