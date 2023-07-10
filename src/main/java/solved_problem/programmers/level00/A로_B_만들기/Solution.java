package solved_problem.programmers.level00.A로_B_만들기;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String before, String after) {
        Map<Character, Integer> beforeMap = initMap(before);
        Map<Character, Integer> afterMap = initMap(after);

        for (char c : before.toCharArray()) {
            if (beforeMap.getOrDefault(c, 0) != afterMap.getOrDefault(c, 0)) {
                return 0;
            }
        }

        return 1;
    }

    private Map<Character, Integer> initMap(String before) {
        Map<Character, Integer> beforeMap = new HashMap<>();
        for (char c : before.toCharArray()) {
            beforeMap.put(c, beforeMap.getOrDefault(c, 0) + 1);
        }
        return beforeMap;
    }

}
