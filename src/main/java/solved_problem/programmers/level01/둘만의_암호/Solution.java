package solved_problem.programmers.level01.둘만의_암호;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public String solution(String s, String skip, int index) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] sChars = s.toCharArray();
        Set<Character> skipSet = new HashSet<>();
        List<Character> filteredAlphabet = new ArrayList<>();

        for (char skipChar : skip.toCharArray()) {
            skipSet.add(skipChar);
        }

        for (int alphabetAsciiNum = 'a'; alphabetAsciiNum <= 'z'; alphabetAsciiNum++) {
            if (skipSet.contains((char)alphabetAsciiNum)) {
                continue;
            }
            filteredAlphabet.add((char)alphabetAsciiNum);
        }

        for (int sCharIndex = 0; sCharIndex < sChars.length; sCharIndex++) {
            char sChar = sChars[sCharIndex];
            int filteredIndex = 0;

            for (int alphaIndex = 0; alphaIndex < filteredAlphabet.size(); alphaIndex++) {
                if (filteredAlphabet.get(alphaIndex) == sChar) {
                    filteredIndex = alphaIndex;
                    break;
                }
            }

            int addedFilteredIndex = (filteredIndex + index) % filteredAlphabet.size();
            stringBuilder.append(filteredAlphabet.get(addedFilteredIndex));
        }

        return stringBuilder.toString();
    }

}
