package leetcode.sort_colors;

/**
 * - 실행 속도 : 0ms (100%)
 * - 메모리 사용량 : 39.2MB (6.79%)
 */

class Solution {
    public void sortColors(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        for (int i = 0; i <= rightIdx; i++) {
            if (nums[i] == 0) {
                swap(nums, i, leftIdx++);
            }

            if (nums[i] == 2) {
                swap(nums, i--, rightIdx--);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
