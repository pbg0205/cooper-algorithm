package solved_problem.baekjoon.스택_수열_1874;

import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int now = 1;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();

            while (now <= input) {
                stack.push(now++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == input) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
