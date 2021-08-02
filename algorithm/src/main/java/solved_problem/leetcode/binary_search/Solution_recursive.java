package solved_problem.leetcode.binary_search;

/**
 * - Runtime: 0 ms, faster than 100.00% of Java
 * - Memory Usage: 39.7 MB, less than 76.89% of Java
 */

public class Solution_recursive {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums,target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }

        int pivot = (left + right) /2;

        if (nums[pivot] == target) {
            return pivot;
        }

        if (nums[pivot] > target) {
            return binarySearch(left, pivot - 1, nums, target);
        }

        if(nums[pivot] < target) {
            return binarySearch(pivot + 1, right, nums, target);
        }

        return -1;
    }
}
