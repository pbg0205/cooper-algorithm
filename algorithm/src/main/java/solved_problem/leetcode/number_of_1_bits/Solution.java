package solved_problem.leetcode.number_of_1_bits;

/**
 * - Runtime: 0 ms, faster than 100.00% of Java
 * - Memory Usage: 35.7 MB, less than 79.07% of Java
 */

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
