package solved_problem.programmers.level02.h_index;

import java.util.Arrays;

public class Solution2 {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) {
                return h;
            }
        }

        return 0;
    }

    private boolean isValid(int[] citations, int h) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }

        return count >= h;
    }
}
