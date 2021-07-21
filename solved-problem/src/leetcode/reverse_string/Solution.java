package leetcode.reverse_string;

/**
 * - Runtime: 1 ms, faster than 95.59% of Java
 * - Memory Usage: 45.5 MB, less than 83.53% of Java
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
