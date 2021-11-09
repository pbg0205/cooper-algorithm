package solved_problem.programmers.level02.구명보트;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int boatCount = 0;
        int lightIdx = 0;
        for (int heavyIdx = people.length - 1; heavyIdx >= lightIdx; heavyIdx--) {
            int sum = people[heavyIdx] + people[lightIdx];
            if (sum <= limit) {
                lightIdx++;
            }
            boatCount++;
        }

        return boatCount;
    }
}
