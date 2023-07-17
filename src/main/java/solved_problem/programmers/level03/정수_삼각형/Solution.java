package solved_problem.programmers.level03.정수_삼각형;

import java.util.Arrays;

class Solution {

    public int solution(int[][] triangle) {
        int[][] memorization = new int[triangle.length][triangle.length];
        for (int i = 0; i < memorization.length; i++) {
            Arrays.fill(memorization[i], Integer.MIN_VALUE);
        }

        max(0, 0, triangle, memorization);

        return memorization[0][0];
    }

    private int max(int y, int x, int[][] triangle, int[][] memorization) {
        if (y == triangle.length) {
            return 0;
        }

        if (memorization[y][x] != Integer.MIN_VALUE) {
            return memorization[y][x];
        }

        memorization[y][x] = triangle[y][x] + Math.max(
                max(y + 1, x, triangle, memorization),
                max(y + 1, x + 1, triangle, memorization)
        );

        return memorization[y][x];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println("result = " + result);
    }

}
