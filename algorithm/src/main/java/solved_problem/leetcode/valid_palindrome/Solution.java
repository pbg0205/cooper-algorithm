package solved_problem.leetcode.valid_palindrome;

/**
 * - Runtime: 26 ms, faster than 22.19% of Java
 * - Memory Usage: 40.3 MB, less than 20.26% of Java
 */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
