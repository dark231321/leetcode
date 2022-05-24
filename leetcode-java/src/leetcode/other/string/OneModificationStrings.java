package leetcode.other.string;

import java.util.Arrays;

public class OneModificationStrings {

    // ple -> plt true
    // ple -> le true
    // ple -> plek true
    // ple -> pltk false

    private static Boolean oneUpdate(String first, String second) {
        boolean isMod = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (isMod) {
                    return false;
                }
                isMod = true;
            }
        }
        return true;
    }

    private static Boolean oneDelete(String first, String second) {
        boolean isMod = false;
        int i = 0;
        int j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (isMod) {
                    return false;
                }
                isMod = true; i++;
            } else {
                i++; j++;
            }
        }
        return true;
    }


    private static Boolean oneInsert(String first, String second) {
        boolean isMod = false;
        int i = 0;
        int j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (isMod) {
                    return false;
                }
                isMod = true; j++;
            } else {
                i++; j++;
            }
        }
        return true;
    }

    public static Boolean oneModificationStrings(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        if (first.length() == second.length()) {
            return oneUpdate(first, second);
        } else if (first.length() > second.length()) {
            return oneDelete(first, second);
        }
        return oneInsert(first, second);
    }


    public static Boolean oneModificationStringsSec(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String firstBigger = first.length() > second.length() ? first : second;
        String secondBigger = first.length() > second.length() ? second : first;

        boolean isMod = false;
        int i = 0;
        int j = 0;
        while (i < firstBigger.length() && j < secondBigger.length()) {
            if (firstBigger.charAt(i) != secondBigger.charAt(j)) {
                if (isMod) {
                    return false;
                }
                isMod = true;
            } else {
                j++;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("True: " + oneModificationStringsSec("111", "11"));
        System.out.println("True: " + oneModificationStringsSec("112", "11"));
        System.out.println("True: " + oneModificationStringsSec("12", "11"));
        System.out.println("True: " + oneModificationStringsSec("1122", "122"));
        System.out.println("False: " +oneModificationStringsSec("1132", "122"));
        System.out.println("False: " +oneModificationStringsSec("1111", "11"));
        System.out.println("False: " +oneModificationStringsSec("111", "12"));
        System.out.println("True: " + oneModificationStringsSec("111", "11"));
    }
}
