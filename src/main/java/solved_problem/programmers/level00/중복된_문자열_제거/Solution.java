package solved_problem.programmers.level00.중복된_문자열_제거;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public String solution(String my_string) {
        Set<Character> used = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (used.contains(c)) {
                continue;
            }

            builder.append(c);
            used.add(c);
        }

        return builder.toString();
    }

}
