package solved_problem.leetcode.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int counter = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);

            if (tMap.containsKey(cRight)) {
                tMap.put(cRight, tMap.get(cRight) - 1);

                if (tMap.get(cRight) == 0) {
                    counter -= 1;
                }
            }

            while (counter == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char cLeft = s.charAt(left);

                if (tMap.containsKey(cLeft)) {
                    tMap.put(cLeft, tMap.get(cLeft) + 1);

                    if (tMap.get(cLeft) >= 1) {
                        counter += 1;
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
