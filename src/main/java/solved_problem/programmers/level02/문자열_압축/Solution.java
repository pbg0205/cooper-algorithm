package solved_problem.programmers.level02.문자열_압축;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. time complexity : O((n / charLen)) : O(n/charLen + m)
 * <p>
 * split 함수의 시간 복잡도: O(n/charLen)
 * <p>
 * compress 함수의 시간 복잡도: O(m)
 * <p>
 * 2.
 */


class Solution {

    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int charLen = 1; charLen <= s.length(); charLen++) {
            List<String> tokens = split(s, charLen);
            int compressedLen = compress(tokens);
            min = Math.min(compressedLen, min);
        }

        return min;
    }

    private List<String> split(String source, int charLen) {
        List<String> tokens = new ArrayList<>();

        for (int idx = 0; idx < source.length(); idx += charLen) {
            int nextIdx = idx + charLen;
            if (nextIdx >= source.length()) {
                nextIdx = source.length();
            }

            tokens.add(source.substring(idx, nextIdx));
        }

        return tokens;
    }

    private int compress(List<String> tokens) {
        int count = 1;
        String previousToken = "";
        StringBuilder builder = new StringBuilder();

        for (String token : tokens) {
            if (token.equals(previousToken)) {
                count++;
            } else {
                if (count > 1) {
                    builder.append(count);
                }

                builder.append(previousToken);
                previousToken = token;
                count = 1;
            }
        }

        if (count > 1) {
            builder.append(count);
        }

        builder.append(previousToken);

        return builder.length();
    }

}
