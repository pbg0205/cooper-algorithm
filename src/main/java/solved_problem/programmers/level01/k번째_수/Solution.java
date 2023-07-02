package solved_problem.programmers.level01.k번째_수;

import java.util.Arrays;

class Solution {

    public int[] solution(int[] arr, int[][] commands) {
        int[] answers = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int from = commands[idx][0] - 1;
            int to = commands[idx][1];
            int target = commands[idx][2] - 1;

            int[] copiedNums = Arrays.copyOfRange(arr, from, to);
            Arrays.sort(copiedNums);

            answers[idx] = copiedNums[target];
        }

        return answers;
    }

}
