package solved_problem.programmers.level02.문자열_압출;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        for (int charLen = 1; charLen <= s.length(); charLen++) {
            List<String> tokens = split(s, charLen);
            for (String token : tokens) {
                int compressedLen = compress(tokens);
                if (compressedLen < min) {
                    min = compressedLen;
                }
            }
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
                continue;
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
