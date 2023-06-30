package solved_problem.programmers.level02.모음사전;

import java.util.ArrayList;
import java.util.List;

/**
 * word 값을 하나씩 추가하면서 재귀 함수를 통해 넘기는 문제
 */
class Solution {

    private static final char[] CHARS = "AEIOU".toCharArray();

    public int solution(String word) {
        return generate("").indexOf(word);
    }

    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words;
        }

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }

        return words;
    }

}
