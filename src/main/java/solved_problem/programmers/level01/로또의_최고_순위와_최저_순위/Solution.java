package solved_problem.programmers.level01.로또의_최고_순위와_최저_순위;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;

        Set<Integer> winSet = new HashSet<>();
        Set<Integer> lottoSet = new HashSet<>();

        for (Integer lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            lottoSet.add(lotto);
        }

        for (Integer winNum : win_nums) {
            winSet.add(winNum);
        }

        int matchedCount = 0;

        for (Integer lotto : lottos) {
            if (winSet.contains(lotto)) {
                matchedCount++;
            }
        }

        int max = getGrade(matchedCount + zeroCount);
        int min = getGrade(matchedCount);

        return new int[]{max, min};
    }

    private int getGrade(int matchedCount) {
        int count = 7;
        if (matchedCount >= 2) {
            return count - matchedCount;
        } else {
            return 6;
        }
    }
}

