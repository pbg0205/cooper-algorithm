package solved_problem.leetcode.optimal_partition_of_string;

import java.util.Arrays;

public class Solution {

    public int partitionString(String s) {
        int[] lastAlphaIndex = new int[26];
        Arrays.fill(lastAlphaIndex, -1);

        int count = 1;
        int subStringStart = 0;
        for (int index = 0; index < s.length(); index++) {
            int currentAlphaIndex = s.charAt(index) - 'a';
            if (lastAlphaIndex[currentAlphaIndex] >= subStringStart) {
                count++;
                subStringStart = index;
            }
            lastAlphaIndex[currentAlphaIndex] = index;
        }

        return count;
    }

}
