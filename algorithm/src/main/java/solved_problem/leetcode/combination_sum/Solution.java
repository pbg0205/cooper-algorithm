package solved_problem.leetcode.combination_sum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backTrack(candidates, 0, target, currList, result);
        return result;
    }

    private void backTrack(int[] candidates, int start, int target, List<Integer> currList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currList.add(candidates[i]);
                backTrack(candidates, i, target - candidates[i], currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
