package solved_problem.programmers.level02.무인도_여행;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private int[][] direction = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        char[][] map = initMap(maps);
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visit[i][j] || map[i][j] == 'X') {
                    continue;
                }

                int sum = bfs(map, visit, new Point(i, j));
                answer.add(sum);
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer.stream()
                .mapToInt(Integer::valueOf)
                .sorted().toArray();
    }

    private char[][] initMap(String[] maps) {
        char[][] map = new char [maps.length][maps[0].length()];
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        return map;
    }

    private int bfs(char[][] map, boolean[][] visit, Point point) {
        int sum = map[point.y][point.x] - '0';
        visit[point.y][point.x] = true;

        Queue<Point> queue = new LinkedList<>();

        queue.add(point);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int[] ints : direction) {
                int ny = currentPoint.y + ints[0];
                int nx = currentPoint.x + ints[1];

                if (isOutBound(ny, nx, visit.length, visit[0].length) || visit[ny][nx] ||map[ny][nx] == 'X') {
                    continue;
                }

                int addNumber = map[ny][nx] - '0';
                visit[ny][nx] = true;

                sum += addNumber;
                queue.add(new Point(ny, nx));
            }
        }

        return sum;
    }

    private boolean isOutBound(int y, int x, int ySize, int xSize) {
        return (y < 0) || (y >= ySize) || (x < 0) || (x >= xSize);
    }

    private static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});

        for (int i : result) {
            System.out.println(i);
        }
    }

}
