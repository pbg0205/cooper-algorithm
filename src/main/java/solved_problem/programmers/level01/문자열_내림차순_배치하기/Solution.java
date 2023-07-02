package solved_problem.programmers.level01.문자열_내림차순_배치하기;

import java.util.Arrays;

class Solution {

    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder builder = new StringBuilder();
        for (int idx = chars.length - 1; idx >= 0; idx--) {
            builder.append(chars[idx]);
        }

        return builder.toString();
    }

}
