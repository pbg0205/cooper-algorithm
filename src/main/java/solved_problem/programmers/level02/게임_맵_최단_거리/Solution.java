package solved_problem.programmers.level02.게임_맵_최단_거리;

import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0));


        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();

            System.out.println(pollNode);

            if (pollNode.getRow() == n - 1 && pollNode.getCol() == m - 1) {
                return pollNode.getCount();
            }

            for (int i = 0; i < 4; i++) {
                int nx = pollNode.getRow() + dx[i];
                int ny = pollNode.getCol() + dy[i];

                if (isBoundary(nx, ny, n, m) && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, pollNode.getCount() + 1));
                }
            }
        }

        return -1;
    }

    private boolean isBoundary(int nx, int ny, int n, int m) {
        return (0 <= nx && nx < n) && (0 <= ny && ny < m);
    }
}

class Node {
    private int row;
    private int col;
    private int count = 1;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getCount() {
        return count;
    }
}
