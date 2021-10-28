package solved_problem.baekjoon.키로거_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> frontStack = new Stack<>();
        Stack<Character> backStack = new Stack<>();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            char[] charArr = br.readLine().toCharArray();

            for (char c : charArr) {
                if ((Character.isAlphabetic(c) || Character.isDigit(c))) {
                    frontStack.push(c);
                    continue;
                }

                if (c == '<') {
                    if (!frontStack.isEmpty()) {
                        backStack.push(frontStack.pop());
                        continue;
                    }
                }

                if (c == '>') {
                    if (!backStack.isEmpty()) {
                        frontStack.push(backStack.pop());
                        continue;
                    }
                }

                if (c == '-') {
                    if (!frontStack.isEmpty()) {
                        frontStack.pop();
                    }
                }
            }

            while (!frontStack.isEmpty()) {
                backStack.push(frontStack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!backStack.isEmpty()) {
                sb.append(backStack.pop());
            }

            System.out.println(sb.toString());
        }
        br.close();
    }
}
