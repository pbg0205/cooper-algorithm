package leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * - Runtime: 0 ms, faster than 100.00%
 * - Memory Usage: 37.5 MB, less than 90.21%
 */

class Solution {
    char[][] telephone = {
        {'0'},
            {'0'}, {'a','b','c'}, {'d','e','f'},
            {'g','h','i'}, {'j','k','l'}, {'m','n','o'},
            {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}
    };

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("") || digits == null) {
            return result;
        }

        combination(digits, 0, new StringBuilder());
        return result;
    }

    private void combination(String digits, int nowIdx, StringBuilder sb) {
        if (nowIdx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int number = digits.charAt(nowIdx) - '0';
        char[] alphabetsInNumber = telephone[number];

        for (int i = 0; i < alphabetsInNumber.length; i++) {
            sb.append(alphabetsInNumber[i]);
            combination(digits, nowIdx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
