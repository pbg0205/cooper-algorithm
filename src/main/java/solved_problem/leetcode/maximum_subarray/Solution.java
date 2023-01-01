package solved_problem.leetcode.maximum_subarray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray_kadane(nums);
    }

    public int maxSubArray_dp(int[] nums) {
        List<Integer> sumList = new ArrayList<>();

        int sum = 0;
        for (int num : nums) {
            sum += num;

            sumList.add(sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        int max = Integer.MIN_VALUE;
        for (Integer element : sumList) {
            max = max < element ? element : max;
        }

        return max;
    }

    public int maxSubArray_kadane(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum = Math.max(num, currentSum + num);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }
}
