package org.example.leetcode.other.string;

public class ZipString {

    public static String zipString(String str) {
        if (str.length() == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(prepareSize(str));
        int size = 1;
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (tmp!=str.charAt(i)) {
                stringBuilder.append(tmp).append(size);
                size = 1;
                tmp = str.charAt(i);
            } else {
                size++;
            }
        }
        stringBuilder.append(tmp).append(size);
        return stringBuilder.toString();
    }

    private static int prepareSize(String str) {
        int size = 0;
        int tmpCount = 1;
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (tmp!=str.charAt(i)) {
                size = size + 1 + String.valueOf(tmpCount).length();
                tmp = str.charAt(i);
                tmpCount = 1;
            }
            tmpCount ++;
        }
        size = size + 1 + String.valueOf(tmpCount).length();
        return size;
    }

    public static void main(String[] args) {
        System.out.println(zipString("ааЬааассссссссссссссс").length());
    }
}
