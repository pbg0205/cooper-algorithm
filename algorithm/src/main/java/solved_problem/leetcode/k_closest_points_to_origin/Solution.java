package solved_problem.leetcode.k_closest_points_to_origin;

import java.util.PriorityQueue;

/**
 * - 실행 시간 : 33ms (31.11%)
 * - 메모리 사용량 : 47.5MB (69.80%)
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            Point point = pq.poll();
            result[i][0] = point.getX();
            result[i][1] = point.getY();
        }

        return result;
    }
}

class Point implements Comparable<Point>{
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

    @Override
    public int compareTo(Point other) {
        int x1 = this.x * this.x;
        int y1 = this.y * this.y;
        int x2 = other.x * other.x;
        int y2 = other.y * other.y;

        return Integer.compare((x1 + y1), (x2 + y2));
    }
}
