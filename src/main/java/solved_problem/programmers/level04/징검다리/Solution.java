package solved_problem.programmers.level04.징검다리;

import java.util.Arrays;

class Solution {

    public int solution(int distance, int[] rocks, int n) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;

        Arrays.sort(rocks);

        int start = 0;
        int end = distance + 1;

        while (start < end - 1) {
            int d = (start + end) / 2;
            if (isValid(rocks, d, n)) {
                start = d;
            } else {
                end = d;
            }
        }

        return start;
    }

    private boolean isValid(int[] rocks, int d, int n) {
        long removeCount = 0L;
        int lastRockLocation = 0;

        for (int nowRockLocation : rocks) {
            if (nowRockLocation - lastRockLocation < d) {
                removeCount++;
                continue;
            }
            lastRockLocation = nowRockLocation;
        }

        return removeCount <= n;
    }

}
