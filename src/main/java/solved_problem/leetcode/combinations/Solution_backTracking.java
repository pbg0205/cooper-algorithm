package solved_problem.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution_backTracking {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void bfs(int n, int k, int start, List<Integer> list, final List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            bfs(n, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
