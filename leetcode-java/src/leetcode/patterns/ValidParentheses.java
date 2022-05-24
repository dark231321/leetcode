package leetcode.patterns;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            var tmp = s.charAt(i);
            if (tmp == '(' || tmp == '{' || tmp == '[') {
                stack.add(tmp);
            } else {
                var popTmp = stack.pollLast();
                if (Objects.isNull(popTmp) || (tmp==')' && popTmp != '(') || (tmp == ']' && popTmp != '[') || (tmp == '}' && popTmp != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
