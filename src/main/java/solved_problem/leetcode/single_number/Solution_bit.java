package solved_problem.leetcode.single_number;

/**
 * - Runtime: 1 ms, faster than 95.22% of Java
 * - Memory Usage: 39.2 MB, less than 67.06% of Java
 * - a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
 */

class Solution_bit {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result  ^= num;
        }

        return result;
    }
}
