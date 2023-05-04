package solved_problem.programmers.level01.둘만의_암호;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public String solution(String s, String skip, int index) {
        StringBuilder builder = new StringBuilder();

        List<Character> secretList = new ArrayList<>();
        Map<Character, Integer> secretIndexMap = new HashMap<>();

        int secretListIdx = 0;
        for (int ascii = 'a'; ascii <= 'z'; ascii++) {
            char asciiChar = (char) ascii;
            if (skip.contains(String.valueOf(asciiChar))) {
                continue;
            }
            secretList.add(asciiChar);
            secretIndexMap.put(asciiChar, secretListIdx++);
        }

        for (char c : s.toCharArray()) {
            int secretIdx = (secretIndexMap.get(c) + index) % secretList.size();
            builder.append(secretList.get(secretIdx));
        }

        return builder.toString();
    }

}
