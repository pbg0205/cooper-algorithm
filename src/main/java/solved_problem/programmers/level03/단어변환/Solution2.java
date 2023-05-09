package solved_problem.programmers.level03.단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (currentState.word.equals(target)) {
                return currentState.step;
            }

            for (int index = 0; index < words.length; index++) {
                if (isVisited[index]) {
                    continue;
                }

                if (!isConvertable(currentState.word, words[index])) {
                    continue;
                }

                isVisited[index] = true;
                queue.add(new State(words[index], currentState.step + 1));
            }

        }

        return 0;
    }

    private boolean isConvertable(String currentWord, String compareWord) {
        char[] currentWordChars = currentWord.toCharArray();
        char[] compareWordChars = compareWord.toCharArray();

        int diffCount = 0;
        for (int index = 0; index < currentWord.length(); index++) {
            if (currentWordChars[index] != compareWordChars[index]) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }

    private static class State {
        private final String word;
        private final int step;

        public State(String word, int step) {
            this.word = word;
            this.step = step;
        }

    }

}
