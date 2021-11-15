package solved_problem.programmers.level03.빛의_경로_싸이클;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int rowSize;
    private int colSize;
    private int directionSize;
    private boolean[][][] isVisited;
    private int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[] solution(String[] grid) {
        List<Integer> answerList = new ArrayList<>();

        rowSize = grid.length;
        colSize = grid[0].length();
        directionSize = direction.length;
        isVisited = new boolean[rowSize][colSize][directionSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                for (int dir = 0; dir < directionSize; dir++) {
                    if (isVisited[row][col][dir]) {
                        continue;
                    }
                    int cycleCount = searchCycle(grid, row, col, dir);
                    answerList.add(cycleCount);
                }
            }
        }
        return answerList.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int searchCycle(String[] grid, int row, int col, int dir) {
        int count = 0;

        while (!isVisited[row][col][dir]) {
            count++;
            isVisited[row][col][dir] = true;

            if (grid[row].charAt(col) == 'L') {
                dir = (dir - 1 < 0) ? directionSize - 1 : dir - 1;
            }

            if (grid[row].charAt(col) == 'R') {
                dir = (dir + 1 >= 4) ? 0 : dir + 1;
            }

            row = (row + direction[dir][0] + rowSize) % rowSize;
            col = (col + direction[dir][1] + colSize) % colSize;
        }
        return count;
    }
}
