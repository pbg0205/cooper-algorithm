package solved_problem.programmers.level02.주식가격;


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{1, 2, 3, 2, 3});
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}
