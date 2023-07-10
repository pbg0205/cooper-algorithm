package solved_problem.programmers.level00.다음에_올_숫자;

class Solution {
    public int solution(int[] common) {
        int lastIndex = common.length - 1;

        if (isArithmeticSequence(common[0], common[1], common[2])) {
            int degree = common[1] - common[0];
            return common[lastIndex] + degree;
        }

        if (isGeometricSequence(common[0], common[1], common[2])) {
            int ratio = common[1] / common[0];
            return common[lastIndex] * ratio;
        }

        throw new IllegalArgumentException();
    }

    private boolean isArithmeticSequence(int a, int b, int c) {
        return 2 * b == a + c;
    }

    private boolean isGeometricSequence(int a, int b, int c) {
        return (b * b) == (a * c);
    }

}
