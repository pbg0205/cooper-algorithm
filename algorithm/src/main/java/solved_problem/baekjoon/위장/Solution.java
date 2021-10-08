package solved_problem.baekjoon.위장;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.putIfAbsent(clothe[1], 1);
            map.computeIfPresent(clothe[1], (k,v) -> v + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue();
        }

        return answer - 1;
    }
}