package leetcode.other.string;

public class UniqueChars {

    // 0000 0000 0000 0000 0000 0000 0000 0000
    public static Boolean isUnique(String value) {
        int isUniqueBitMassive = 0;
        for (char el: value.toCharArray()) {
            int pos = el - 'a';
            if ((isUniqueBitMassive >> pos) % 2 != 0) {
                return true;
            }
            isUniqueBitMassive |= (1 << pos);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abota"));
    }
}
