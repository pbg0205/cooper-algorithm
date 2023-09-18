package solved_problem.baekjoon.후위_표기식2_1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        String expression = reader.readLine();

        Stack<Double> stack = new Stack<>();
        Map<Character, Double> map = new HashMap<>();

        for (char c : expression.toCharArray()) {
            if (Character.isAlphabetic(c) && !map.containsKey(c)) {
                double inputNum = Double.parseDouble(reader.readLine());
                map.put(c, inputNum);
            }
        }

        for (char c : expression.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.push(map.get(c));
            }

            if (c == '+') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num1 + num2);
            }

            if (c == '-') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 - num1);
            }

            if (c == '*') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num1 * num2);
            }

            if (c == '/') {
                double num1 = stack.pop();
                double num2 = stack.pop();

                stack.push(num2 / num1);
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));

        reader.close();
    }

}
