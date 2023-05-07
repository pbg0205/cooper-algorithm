package solved_problem.programmers.level03.순위;

class Solution {

    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];

        for (int[] result : results) {
            int u = result[0] - 1;
            int v = result[1] - 1;
            graph[u][v] = true;
        }

        int answer = 0;
        for (int u = 0; u < n; u++) {
            int winCount = countWin(u, graph, new boolean[n]) - 1;
            int loseCount = countLose(u, graph, new boolean[n]) - 1;

            if (winCount + loseCount + 1 == n) {
                answer++;
            }
        }

        return answer;
    }

    private int countWin(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph[u].length; v++) {
            if (!graph[u][v] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countWin(v, graph, isVisited);
        }

        return count;
    }

    private int countLose(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;

        for (int v = 0; v < graph.length; v++) {
            if (!graph[v][u] || isVisited[v]) {
                continue;
            }
            isVisited[v] = true;
            count += countLose(v, graph, isVisited);
        }

        return count;
    }

}
