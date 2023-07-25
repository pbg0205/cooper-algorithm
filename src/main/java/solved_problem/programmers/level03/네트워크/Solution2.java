package solved_problem.programmers.level03.네트워크;

import java.util.Stack;

class Solution2 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] isVisited = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (isVisited[node]) {
                continue;
            }

            visitAll(node, isVisited, computers);
            answer++;
        }
        
        return answer;
    }

    private void visitAll(int currentNode, boolean[] isVisited, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);

        while (!stack.isEmpty()) {
            int c = stack.pop();

            if (isVisited[c]) {
                continue;
            }
            isVisited[c] = true;

            for (int next = 0; next < computers[c].length; next++) {
                if (computers[c][next] == 0) {
                    continue;
                }
                stack.push(next);
            }
        }
    }

}
