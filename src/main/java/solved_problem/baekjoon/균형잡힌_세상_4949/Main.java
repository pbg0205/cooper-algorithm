package solved_problem.baekjoon.균형잡힌_세상_4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			Stack<Character> stack = new Stack<>();
			String sentence = br.readLine();

			if (sentence.equals(".")) {
				br.close();
				bw.flush();
				bw.close();
				return;
			}

			char[] words = sentence.toCharArray();
			boolean isPossible = true;

			for (char word : words) {
				if (word == '(')
					stack.push(')');

				if (word == '[') {
					stack.push(']');
				}

				if (word == ')' || word == ']') {
					if (stack.isEmpty()) {
						isPossible = false;
						break;
					}

					if (word == stack.peek()) {
						stack.pop();
					} else {
						isPossible = false;
						break;
					}
				}
			}

			if (isPossible && stack.isEmpty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
	}
}
