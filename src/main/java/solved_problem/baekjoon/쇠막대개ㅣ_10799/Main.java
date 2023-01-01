package solved_problem.baekjoon.쇠막대개ㅣ_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        String input = br.readLine();
        int sumOfSeperatedSticks = 0;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(')	stack.push(i);
            if(input.charAt(i) == ')') {
                if(stack.peek() == i - 1){
                    stack.pop();
                    sumOfSeperatedSticks += stack.size();
                }else {
                    stack.pop();
                    sumOfSeperatedSticks++;
                }
            }
        }

        System.out.println(sumOfSeperatedSticks);

        br.close();
    }
}
