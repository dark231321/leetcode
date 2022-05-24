package leetcode.other.string;

public class ReplaceString {

    public static String replace(String value) {
        if (value.length() == 0) {
            return value;
        }

        StringBuilder sb = new StringBuilder();
        String replacement = "%20";
        char[] symbols = value.toCharArray();
        int lastPos = -1;
        if (symbols[0] == ' ') {
            lastPos = 0;
            sb.append(replacement);
        }

        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == ' ') {
                if (lastPos != i - 1) {
                    lastPos = i;
                    sb.append(replacement);
                }
            } else {
               sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace("Mr John Smith  "));
    }
}
