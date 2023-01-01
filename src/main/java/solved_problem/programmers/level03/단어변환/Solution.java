package solved_problem.programmers.level03.단어변환;

class Solution {

    private static int min = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int beginLength = begin.length();
        int targetLength = target.length();

        if (beginLength != targetLength) {
            return 0;
        }

        dfs(begin, target, words, new boolean[words.length], 0);

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }

    private void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i] || !checkChangeCount(begin, words[i])) {
                continue;
            }
            visited[i] = true;
            dfs(words[i], target, words, visited, count + 1);
            visited[i] = false;
        }
    }

    private boolean checkChangeCount(String begin, String target) {
        int chageCount = 0;

        for (int i = 0; i < begin.length(); i++) {
            char beginChar = begin.charAt(i);
            char targetChar = target.charAt(i);

            if (beginChar != targetChar) {
                chageCount++;
            }
        }

        return chageCount == 1;
    }
}
