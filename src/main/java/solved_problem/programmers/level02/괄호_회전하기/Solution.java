package solved_problem.programmers.level02.괄호_회전하기;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private static final char SMALL_OPEN_BRACKET = '(';
    private static final char SMALL_CLOSE_BRACKET = ')';
    private static final char MIDDLE_OPEN_BRACKET = '{';
    private static final char MIDDLE_CLOSE_BRACKET = '}';
    private static final char LARGE_OPEN_BRACKET = '[';
    private static final char LARGE_CLOSE_BRACKET = ']';

    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        int count = 0;

        for (char bracket : s.toCharArray()) {
            queue.add(bracket);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (isRightBracket(queue)) {
                count++;
            }

            queue.add(queue.poll());
        }

        return count;
    }

    private boolean isRightBracket(Queue<Character> queue) {
        List<Character> brackets = new ArrayList<>(queue);
        Deque<Character> stack = new LinkedList<>();

        for (Character bracket : brackets) {
            if (bracket == SMALL_OPEN_BRACKET || bracket == MIDDLE_OPEN_BRACKET || bracket == LARGE_OPEN_BRACKET) {
                stack.addLast(bracket);
            }

            if (bracket == SMALL_CLOSE_BRACKET || bracket == MIDDLE_CLOSE_BRACKET || bracket == LARGE_CLOSE_BRACKET) {
                if (!matchesBracket(stack, bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean matchesBracket(Deque<Character> stack, Character closeBracket) {
        if (stack.isEmpty()) {
            return false;
        }

        if (closeBracket == SMALL_CLOSE_BRACKET) {
            return stack.pollLast() == SMALL_OPEN_BRACKET;
        }

        if (closeBracket == MIDDLE_CLOSE_BRACKET) {
            return stack.pollLast() == MIDDLE_OPEN_BRACKET;
        }

        return stack.pollLast() == LARGE_OPEN_BRACKET;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("[)(]");
        System.out.println("result = " + result);
    }

}
