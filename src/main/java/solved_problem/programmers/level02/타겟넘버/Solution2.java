package solved_problem.programmers.level02.타겟넘버;

import java.util.Stack;

public class Solution2 {

    public int solution(int[] numbers, int target) {
        int answer = 0;

        Stack<State> stack = new Stack();
        stack.push(new State(0, 0));

        while (!stack.isEmpty()) {
            State nowState = stack.pop();

            if (nowState.depth == numbers.length) {
                if (nowState.sum == target) {
                    answer++;
                }
                continue;
            }

            stack.push(new State(nowState.depth + 1, nowState.sum + numbers[nowState.depth]));
            stack.push(new State(nowState.depth + 1, nowState.sum - numbers[nowState.depth]));
        }

        return answer;
    }

    private static class State {
        private int depth;
        private int sum;

        public State(int depth, int sum) {
            this.depth = depth;
            this.sum = sum;
        }

    }

}
