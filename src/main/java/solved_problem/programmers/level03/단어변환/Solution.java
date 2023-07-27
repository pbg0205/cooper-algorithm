package solved_problem.programmers.level03.단어변환;

import java.util.Objects;

class Solution {

    private int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        if (begin.length() != target.length()) {
            return 0;
        }

        dfs(new boolean[words.length], begin, target, words, 0);

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        return min;
    }

    private void dfs(boolean[] visit, String begin, String target, String[] words, int depth) {
        if (Objects.equals(begin, target)) {
            min = Math.min(depth, min);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && isConvertable(begin, words[i])) {
                visit[i] = true;
                dfs(visit, words[i], target, words, depth + 1);
                visit[i] = false;
            }
        }
    }

    private boolean isConvertable(String begin, String word) {
        char[] beginChars = begin.toCharArray();
        char[] wordChars = word.toCharArray();

        int diffCount = 0;
        for (int i = 0; i < beginChars.length; i++) {
            if (beginChars[i] != wordChars[i]) {
                diffCount++;
            }
        }

        return (diffCount == 1);
    }
}
