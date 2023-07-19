package solved_problem.programmers.level03.등굣길;

import java.util.Arrays;

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isBlocked = new boolean[n][m];
        for (int[] puddle : puddles) {
            isBlocked[puddle[1] - 1][puddle[0] - 1] = true;
        }

        int[][] memorization = new int[n][m];
        for (int[] wayCount : memorization) {
            Arrays.fill(wayCount, -1);
        }

        countWayToSchool(0, 0, n - 1, m - 1, isBlocked, memorization);

        return memorization[0][0];
    }

    private int countWayToSchool(int y, int x, int heightIdx, int widthIdx, boolean[][] isBlock, int[][] memorization) {
        if (y > heightIdx || x > widthIdx) {
            return 0;
        }

        if (isBlock[y][x]) {
            return 0;
        }

        if (memorization[y][x] != -1) {
            return memorization[y][x];
        }

        if (y == heightIdx && x == widthIdx) {
            return 1;
        }

        int total = countWayToSchool(y + 1, x, heightIdx, widthIdx, isBlock, memorization)
                + countWayToSchool(y, x + 1, heightIdx, widthIdx, isBlock, memorization);

        memorization[y][x] = total % 1_000_000_007;

        return memorization[y][x];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(4, 3, new int[][]{{2, 2}});
        System.out.println("result = " + result);
    }

}
