package solved_problem.programmers.level01.k번째수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 implements SolutionInterface {

    public int[] solution(int[] arr, int[][] commands) {
        List<Integer> answers = new ArrayList<>();

        for (int[] command : commands) {
            int startIdx = command[0] - 1;
            int endIdx = command[1];
            int targetIdx = command[2] - 1;

            List<Integer> subList = getSubList(arr, startIdx, endIdx);
            Collections.sort(subList);

            answers.add(subList.get(targetIdx));
        }

        return answers.stream()
                .mapToInt(number -> number)
                .toArray();
    }

    private List<Integer> getSubList(int[] arr, int startIdx, int endIdx) {
        List<Integer> subList = new ArrayList<>();
        for (int idx = startIdx; idx < endIdx; idx++) {
            subList.add(arr[idx]);
        }
        return subList;
    }

}
