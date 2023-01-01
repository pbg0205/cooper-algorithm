package solved_problem.leetcode.binary_search;

/**
 * - Runtime: 0 ms, faster than 100.00% of Java
 * - Memory Usage: 40.3 MB, less than 26.03% of Java
 */

class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums,target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}
