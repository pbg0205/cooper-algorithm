package solved_problem.leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            dfs(nums, 0, i, list, results);
        }

        return results;
    }

    private void dfs(int[] nums, int start, int k, List<Integer> list, List<List<Integer>> results) {
        if (list.size() == k) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, k, list, results);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(new int[] {1, 2, 3});
        System.out.println("result = " + result);
    }

}
