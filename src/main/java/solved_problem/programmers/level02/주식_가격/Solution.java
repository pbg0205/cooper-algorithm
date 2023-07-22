package solved_problem.programmers.level02.주식_가격;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                int index = stack.pollLast();
                answer[index] = i - index;
            }

            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pollLast();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }

}
