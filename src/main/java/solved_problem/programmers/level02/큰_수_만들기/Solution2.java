package solved_problem.programmers.level02.큰_수_만들기;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution2 {

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 앞의 숫자가 뒤의 숫자보다 작은 경우가 없는 경우 통과 (testcase 12)
        while (k-- > 0) {
            stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String actual = solution.solution("4321", 1);
        System.out.println(actual);
    }

}
