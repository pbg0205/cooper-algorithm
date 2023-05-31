package solved_problem.programmers.level01.대충_만든_자판;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> alphaMinMap = new HashMap<>();
        for (String key : keymap) {
            char[] alphabets = key.toCharArray();
            for (int idx = 0; idx < key.length(); idx++) {
                char alphabet = alphabets[idx];
                int count = idx + 1;

                if (alphaMinMap.containsKey(alphabet)) {
                    int minCount = Math.min(alphaMinMap.get(alphabet), count);
                    alphaMinMap.put(alphabet, minCount);
                } else {
                    alphaMinMap.put(alphabet, count);
                }
            }
        }

        for (int idx = 0; idx < targets.length; idx++) {
            int sum = 0;

            for (char alphabet : targets[idx].toCharArray()) {
                if (alphaMinMap.containsKey(alphabet)) {
                    sum += alphaMinMap.get(alphabet);
                } else {
                    sum = -1;
                    break;
                }
            }

            answer[idx] = sum;
        }

        return answer;
    }

}
