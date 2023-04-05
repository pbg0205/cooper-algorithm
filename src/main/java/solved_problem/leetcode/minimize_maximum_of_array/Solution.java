package solved_problem.leetcode.minimize_maximum_of_array;

class Solution {

    public int minimizeArrayValue(int[] nums) {
        long answer = 0;
        long prefixSum = 0;

        for (int index = 0; index < nums.length; ++index) {
            prefixSum += nums[index];
            answer = Math.max(answer, (prefixSum + index) / (index + 1));
        }

        return (int)answer;
    }

}
