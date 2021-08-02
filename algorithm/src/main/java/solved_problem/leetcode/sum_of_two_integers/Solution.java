package solved_problem.leetcode.sum_of_two_integers;

class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
