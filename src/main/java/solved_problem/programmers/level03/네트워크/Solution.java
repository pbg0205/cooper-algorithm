package solved_problem.programmers.level03.네트워크;

class Solution {

    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                count++;
            }
        }

        return count;
    }

    private void dfs(int currentIdx, boolean[] visited, int[][] computers) {
        if (visited[currentIdx]) {
            return;
        }

        visited[currentIdx] = true;

        for (int i = 0; i < computers[currentIdx].length; i++) {
            if (computers[currentIdx][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }
    }
}
