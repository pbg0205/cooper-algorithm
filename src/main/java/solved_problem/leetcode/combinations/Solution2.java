package solved_problem.leetcode.combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution2 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();
		dfs(results, new LinkedList<>(), n, 1, k);
		return results;
	}

	private void dfs(final List<List<Integer>> results, LinkedList<Integer> objects, int n, int start, int k) {
		if (k == 0) {
		}
	}

}
