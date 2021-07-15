package leetcode.combinations;

import java.util.*;

/**
 * - Runtime: 6 ms, faster than 84.25%
 * - Memory Usage: 40.4 MB, less than 47.85%
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int set = (int)Math.pow(2,n) - 1;

        for (int subSet = 1; subSet <= set; subSet++) {
            if (Integer.bitCount(subSet) == k) {
                List<Integer> subList = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if (((1 << j) & subSet) > 0) {
                        subList.add(j + 1);
                    }
                }

                result.add(subList);
            }
        }
        return result;
    }
}
