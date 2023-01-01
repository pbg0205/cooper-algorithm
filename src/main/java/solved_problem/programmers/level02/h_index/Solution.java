package solved_problem.programmers.level02.h_index;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}