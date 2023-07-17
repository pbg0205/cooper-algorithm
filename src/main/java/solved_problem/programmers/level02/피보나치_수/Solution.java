package solved_problem.programmers.level02.피보나치_수;

class Solution {

    public int solution(int n) {
        int[] fibonacci = new int[n + 1];
        fibonacci[1] = 1;
        fibonacci[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1_234_567;
        }

        return fibonacci[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(3);
        System.out.println("result = " + result);
    }

}
