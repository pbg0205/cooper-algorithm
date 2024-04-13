package solved_problem.leetcode.search_in_rotated_sorted_array;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int pivot;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        pivot = left;
        System.out.println("pivot = " + pivot);

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid + 1;
            }

            if (nums[midPivot] > target) {
                right = mid - 1;
            }

            if (nums[midPivot] == target) {
                return midPivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println("result = " + result);
    }
}
