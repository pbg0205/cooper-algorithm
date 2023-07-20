package solved_problem.programmers.level02.올바른_괄호;

import java.util.Stack;

class Solution {

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '(') {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (stack.peek() == '(') {
                stack.pop();
            }
        }

        return stack.isEmpty() ? true : false;
    }

}
