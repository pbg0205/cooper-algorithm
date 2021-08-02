package solved_problem.leetcode.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * 실행 시간 : 6ms
 * 메모리 사용량 : 39.3MB (51.34%)
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (left > right) {
                break;
            }

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength, right - left);
                continue;
            }
            set.remove(s.charAt(left++));
        }
        return maxLength;
    }
}
