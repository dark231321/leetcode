package leetcode.other.string;

public class PalindromeEnglishAlphabet {

    public static boolean isPalindrome(String str) {
        if (str.length() > 52) {
            return false;
        }
        int bitVector = creteBitVector(str);
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int creteBitVector(String str) {
        int res = 0;

        for (Character ch: str.toCharArray()) {
            int index = getIndexCharacter(ch);
            res = toggle(res, index);
        }
        return res;
    }

    private static int toggle(int res, int index) {
        if (index < 0) return res;
        res ^= 1 << index;
        return res;
    }

    private static int getIndexCharacter(Character ch) {
        int a = 'a'; int z = 'z';
        int A = 'A'; int Z = 'Z';

        int tmp = ch;
        if (a <= tmp && tmp <= z) {
            return z - tmp;
        } else if (A <= tmp && tmp <= Z) {
            return Z - tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("!T ato o "));
    }
}
