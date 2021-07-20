package leetcode.hamming_distance;

/**
 * - Runtime: 0 ms, faster than 100.00% of Java
 * - Memory Usage: 36 MB, less than 28.80% of Java
 */

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
