package solved_problem.baekjoon.스택수열_1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Character> result = new ArrayList<>();

        int n = SCANNER.nextInt();
        int count = 1;

        for (int index = 0; index < n; index++) {
            int x = SCANNER.nextInt();

            while (count <= x) {
                stack.push(count++);
                result.add('+');
            }

            if (stack.peek() == x) {
                stack.pop();
                result.add('-');
            } else {
                System.out.println("NO");
                return;
            }
        }

        result.forEach(System.out::println);

    }
}
