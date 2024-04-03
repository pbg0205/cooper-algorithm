package solved_problem.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] nums = IntStream.rangeClosed(1, n).toArray();
        dfs(n, k, 0, nums, list, result);
        return result;
    }

    private void dfs(int n, int k, int start, int[] nums, List<Integer> list, final List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(nums[i]);
            dfs(n, k, i + 1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }
}
