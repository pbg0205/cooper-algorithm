package solved_problem.leetcode.assign_cookies;

import java.util.Arrays;

/**
 * Runtime: 6 ms, faster than 98.29% of Java
 * Memory Usage: 39.9 MB, less than 26.15% of Java
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIdx = 0;
        int cookieIdx = 0;

        while (childIdx < g.length && cookieIdx < s.length) {
            if (s[cookieIdx] >= g[childIdx]) {
                childIdx++;
            }
            cookieIdx++;
        }

        return childIdx;
    }
}
