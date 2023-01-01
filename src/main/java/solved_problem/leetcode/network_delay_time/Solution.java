package solved_problem.leetcode.network_delay_time;


import java.util.*;

class Solution {
    private final List<List<Pair>> graph = new ArrayList<>();

    private int[] distance;

    public int networkDelayTime(int[][] times, int N, int K) {
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[N];
        Arrays.fill(distance, -1);

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            graph.get(u).add(new Pair(v, w));
        }

        bfs(K - 1);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (distance[i] == -1) return -1;
            answer = Math.max(answer, distance[i]);
        }
        return answer;
    }

    private void bfs(int x) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (distance[p.x] != -1 && p.sum >= distance[p.x]) {
                continue;
            }

            distance[p.x] = p.sum;

            for (Pair np : graph.get(p.x)) {
                q.add(new Pair(np.x, p.sum + np.sum));
            }
        }
    }

    class Pair {
        int x;
        int sum;

        Pair(int x, int sum) {
            this.x = x;
            this.sum = sum;
        }
    }
}
