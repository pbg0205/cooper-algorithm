package solved_problem.programmers.level00.평행;

class Solution {

    public int solution(int[][] dots) {

        // (0, 1) - (2, 3)
        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])) {
            return 1;
        }

        // (0, 2) - (1, 3)
        if (getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])) {
            return 1;
        }

        // (0, 3) - (1, 2)
        if (getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) {
            return 1;
        }

        return 0;
    }

    private double getSlope(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }

}
