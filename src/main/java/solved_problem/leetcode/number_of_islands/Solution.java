package solved_problem.leetcode.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * - 실행 시간 : 2 ms (52.15%)
 * - 메모리 사용량 : 41.4 MB (56.20%)
 */

public class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int rowSize;
    int colSize;
    int result;

    public int numIslands(char[][] grid) {
        rowSize = grid.length;
        colSize = grid[0].length;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == '1') {
                    BFS(grid, new Point(row, col));
                    result += 1;
                }
            }
        }

        return result;
    }

    private void BFS(char[][] grid, Point point) {
        Queue<Point> queue = new LinkedList<>();
        int numberOfDirection = dx.length;

        queue.add(point);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i < numberOfDirection; i++) {
                int nx = currentPoint.getX() + dx[i];
                int ny = currentPoint.getY() + dy[i];

                if (isBoundary(nx, ny) && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private boolean isBoundary(int x, int y) {
        return (0 <= x && x < rowSize) && (0 <= y && y < colSize);
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
