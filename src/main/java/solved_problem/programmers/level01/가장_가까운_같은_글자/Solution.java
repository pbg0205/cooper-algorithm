package solved_problem.programmers.level01.가장_가까운_같은_글자;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<Integer> solution(String s) {
        int answerIndex = 0;
        List<Integer> answers = new ArrayList<>();

        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (char alphabet : s.toCharArray()) {
            if (!alphabetMap.containsKey(alphabet)) {
                alphabetMap.put(alphabet, answerIndex);
                answers.add(-1);
                answerIndex++;
                continue;
            }

            int alphabetIndex = alphabetMap.get(alphabet);
            int indexDifference = answerIndex - alphabetIndex;
            alphabetMap.put(alphabet, answerIndex);
            answers.add(indexDifference);
            answerIndex++;
        }

        return answers;
    }

}
