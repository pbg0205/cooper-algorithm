package solved_problem.baekjoon.괄호_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerBuilder = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        for (int testcase = 0; testcase < n; testcase++) {
            char[] inputStr = reader.readLine().toCharArray();
            String answer = isNormalBracket(inputStr) ? "YES" : "NO";
            answerBuilder.append(answer).append("\n");
        }

        System.out.println(answerBuilder);
    }

    private static boolean isNormalBracket(char[] inputStr) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : inputStr) {
            if (bracket == '(') {
                stack.push(bracket);
                continue;
            }

            if (bracket == ')' && !stack.isEmpty()) {
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty() ? true : false;
    }

}
