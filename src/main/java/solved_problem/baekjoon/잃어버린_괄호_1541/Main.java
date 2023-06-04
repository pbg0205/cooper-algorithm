package solved_problem.baekjoon.잃어버린_괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        System.out.println(calculateMinSum(expression));

        reader.close();
    }

    private static int calculateMinSum(String expression) {
        int sum = Integer.MAX_VALUE;
        String[] addExpressions = expression.split("-");

        for (String addExpression : addExpressions) {
            String[] numbers = addExpression.split("\\+");
            int tempSum = Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();

            if (sum == Integer.MAX_VALUE) {
                sum = tempSum;
            } else {
                sum -= tempSum;
            }
        }

        return sum;
    }

}
