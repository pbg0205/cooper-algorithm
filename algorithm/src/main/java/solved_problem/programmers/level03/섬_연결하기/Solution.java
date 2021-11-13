package solved_problem.programmers.level03.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int total = 0;
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            int fromParent = findParent(parents, from);
            int toParent = findParent(parents, to);

            if (fromParent == toParent) {
                continue;
            }

            total += weight;
            parents[from] = fromParent;
        }

        return total;
    }

    private int findParent(int[] parents, int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = findParent(parents, parents[node]);
    }
}
