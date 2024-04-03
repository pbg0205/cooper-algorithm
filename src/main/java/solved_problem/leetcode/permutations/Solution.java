package solved_problem.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * - Runtime: 1 ms, faster than 92.92%
 * - Memory Usage: 39.3 MB, less than 43.18%
 */

class Solution {

	public List<List<Integer>> permute(int[] nums) {
		int n = nums.length;

		boolean[] visited = new boolean[n];
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();

		dfs(n, visited, nums, list, result);

		return result;
	}

	private void dfs(final int n, boolean[] visited, int[] nums, List<Integer> list, final List<List<Integer>> result) {
		if (list.size() == n) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;

				dfs(n, visited, nums, list, result);

				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}
