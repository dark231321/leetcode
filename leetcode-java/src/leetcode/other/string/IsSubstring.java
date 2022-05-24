package leetcode.other.string;

public class IsSubstring {

    public static Boolean isSubstring(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String doubleS = s1 + s1;
            return doubleS.contains(s2);
        }
        return false;
    }

    // waterbottle --> erbottlewat
    public static void main(String[] args) {
        System.out.println(isSubstring("erbottlewat", "waterbottle"));
    }
}
