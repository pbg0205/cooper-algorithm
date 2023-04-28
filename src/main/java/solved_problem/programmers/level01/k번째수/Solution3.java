package solved_problem.programmers.level01.k번째수;

import java.util.Arrays;

public class Solution3 implements SolutionInterface {

    public int[] solution(int[] arr, int[][] commands) {
        int[] answers = new int[commands.length];

        for (int index = 0; index < commands.length; index++) {
            int from = commands[index][0] - 1;
            int to = commands[index][1];
            int targetIdx = commands[index][2] - 1;

            //
            int[] subArray = Arrays.copyOfRange(arr, from, to);
            Arrays.sort(subArray);

            answers[index] = subArray[targetIdx];
        }

        return answers;
    }

}
