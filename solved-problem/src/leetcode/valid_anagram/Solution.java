package leetcode.valid_anagram;

import java.util.Arrays;

/**
 * - 실행 시간 : 2ms(95.09%)
 * - 메모리 사용량 : 39MB(86.74%)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        s = String.valueOf(sCharArr);
        t = String.valueOf(tCharArr);

        return s.equals(t);
    }
}
