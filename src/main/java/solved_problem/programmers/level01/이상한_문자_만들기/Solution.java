package solved_problem.programmers.level01.이상한_문자_만들기;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public String solution(String s) {
        // split 메서드가 음수일 경우에는 끝의 공백을 제거하지 않는다. (limit >= 0 일 경우, 공백 제거)
        List<String> words = Arrays.stream(s.split(" ", -1)).collect(Collectors.toList());

        return words.stream()
                .map(this::convertStrangeWord)
                .collect(Collectors.joining(" "));
    }

    private String convertStrangeWord(String word) {
        char[] alphabets = word.toCharArray();
        for (int idx = 0; idx < alphabets.length; idx++) {
            if (!Character.isAlphabetic(alphabets[idx])) {
                continue;
            }
            alphabets[idx] = (idx % 2 == 0) ?
                    Character.toUpperCase(alphabets[idx]) :
                    Character.toLowerCase(alphabets[idx]);
        }

        return String.valueOf(alphabets);
    }

}
