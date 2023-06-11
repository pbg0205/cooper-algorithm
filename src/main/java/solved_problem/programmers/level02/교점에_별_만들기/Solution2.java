package solved_problem.programmers.level02.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Point 관련 로직을 이관하여 문제 풀이
 */
public class Solution2 {

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int baseIdx = 0; baseIdx < line.length; baseIdx++) {
            for (int compareIdx = baseIdx + 1; compareIdx < line.length; compareIdx++) {
                Point intersection = Point.intersection(
                        line[baseIdx][0], line[baseIdx][1], line[baseIdx][2],
                        line[compareIdx][0], line[compareIdx][1], line[compareIdx][2]
                );

                if (intersection == null) {
                    continue;
                }

                points.add(intersection);
            }
        }

        Point minPoint = Point.minimumPoint(points);
        Point maxPoint = Point.maximumPoint(points);

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] map = new char[height][width];
        for (char[] row : map) {
            Arrays.fill(row, '.');
        }

        for (Point point : points) {
            int y = (int) (maxPoint.y - point.y);
            int x = (int) (point.x - minPoint.x);
            map[y][x] = '*';
        }

        String[] result = new String[map.length];
        for (int idx = 0; idx < map.length; idx++) {
            result[idx] = String.valueOf(map[idx]);
        }

        return result;
    }

    private static final class Point {
        private final long y;
        private final long x;

        public Point(long y, long x) {
            this.y = y;
            this.x = x;
        }

        public static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
            double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
            double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);

            if (!isNumberic(x, y)) {
                return null;
            }

            return new Point((long) y, (long) x);
        }

        private static boolean isNumberic(double x, double y) {
            return x % 1 == 0 && y % 1 == 0;
        }

        public static Point minimumPoint(List<Point> points) {
            long minY = Long.MAX_VALUE;
            long minX = Long.MAX_VALUE;

            for (Point point : points) {
                minY = Math.min(minY, point.y);
                minX = Math.min(minX, point.x);
            }

            return new Point(minY, minX);
        }

        public static Point maximumPoint(List<Point> points) {
            long maxY = Long.MIN_VALUE;
            long maxX = Long.MIN_VALUE;

            for (Point point : points) {
                maxY = Math.max(maxY, point.y);
                maxX = Math.max(maxX, point.x);
            }

            return new Point(maxY, maxX);
        }

    }
}
