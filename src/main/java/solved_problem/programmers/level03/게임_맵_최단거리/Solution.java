package solved_problem.programmers.level03.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 시간 복잡도 : O(MN)
 * - 간선이 4종류(up, down, left, right) 이므로 X4 를 해야하지만 상수는 제거되므로 O(MN)
 */
class Solution {

    private final int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int solution(int[][] maps) {
        int ySize = maps.length;
        int xSize = maps[0].length;

        boolean[][] isVisited = new boolean[ySize][xSize];
        Queue<State> queue = new LinkedList<>();

        queue.add(new State(0, 0, 1));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.y == ySize - 1 && state.x == xSize - 1) {
                return state.count;
            }

            for (int[] direction : direction) {
                int ny = state.y + direction[0];
                int nx = state.x + direction[1];

                if (isOutBound(ny, nx, ySize, xSize)) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                if (maps[ny][nx] == 0) {
                    continue;
                }

                isVisited[ny][nx] = true;
                queue.add(new State(ny, nx, state.count + 1));
            }
        }

        return -1;
    }

    private boolean isOutBound(int y, int x, int ySize, int xSize) {
        return !((y >= 0 && y < ySize) && (x >= 0 && x < xSize));
    }

    private static class State {
        private final int y;
        private final int x;
        private final int count;

        public State(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count1 = solution.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}});

        int count2 = solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});

        System.out.println(count1);
        System.out.println(count2);
    }

}
