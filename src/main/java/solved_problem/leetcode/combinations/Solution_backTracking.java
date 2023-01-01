package solved_problem.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

class Solution_backTracking {

    boolean[] visited;
    List<List<Integer>> result;
    int m;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        visited = new boolean[n];

        m = k;
        backTracking(n, k, 1, new ArrayList<>());

        return result;
    }

    private void backTracking(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backTracking(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
