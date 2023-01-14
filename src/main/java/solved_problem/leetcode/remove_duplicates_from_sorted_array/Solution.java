package solved_problem.leetcode.remove_duplicates_from_sorted_array;

class Solution {

    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index - 1] != nums[index]) {
                nums[insertIndex] = nums[index];
                insertIndex++;
            }
        }

        return insertIndex;
    }

}
