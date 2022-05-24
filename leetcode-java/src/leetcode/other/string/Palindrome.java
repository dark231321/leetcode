package leetcode.other.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Palindrome {

    public static Boolean isPalindrome(String candidate) {
        if (candidate.length() == 0) {
            return true;
        }

        Map<Character, Integer> countSymbols = new HashMap<>();
        for (Character symbol: candidate.toCharArray()) {
            Character lowerCaseSymbol = Character.toLowerCase(symbol);
            Integer symbolsCount = countSymbols.get(lowerCaseSymbol);
            if (Objects.isNull(symbolsCount)) {
                countSymbols.put(lowerCaseSymbol, 1);
            } else {
                countSymbols.put(lowerCaseSymbol, symbolsCount + 1);
            }
        }
        boolean allSymbolsEven = (candidate.length() >> 1) != 0;

        for (Map.Entry<Character, Integer> countSymbol: countSymbols.entrySet()) {
            if ((countSymbol.getValue() >> 1) != 0) {
                if (allSymbolsEven) {
                    allSymbolsEven = false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Tact Соа"));
    }
}
