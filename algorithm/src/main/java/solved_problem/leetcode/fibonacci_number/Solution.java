package solved_problem.leetcode.fibonacci_number;

class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] memorization = new int[n + 1];
        memorization[0] = 0;
        memorization[1] = 1;

        for (int i = 2; i <= n; i++) {
            memorization[i] = memorization[i - 1] + memorization[i - 2];
        }

        return memorization[n];
    }
}
