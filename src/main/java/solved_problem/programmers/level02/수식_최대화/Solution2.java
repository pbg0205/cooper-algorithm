package solved_problem.programmers.level02.수식_최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution2 {

	private List<String[]> precedences;

	private void dfs(String[] operators, int r, int depth, boolean[] visited, String[] currentAnswer, List<String[]> answers) {
		if (depth == r) {
			answers.add(currentAnswer.clone());
			return;
		}

		for (int i = 0; i < operators.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				currentAnswer[depth] = operators[i];
				dfs(operators, r, depth + 1, visited, currentAnswer, answers);
				visited[i] = false;
			}
		}

	}

	public long solution(String expression) {
		precedences = new ArrayList<>();
		dfs("+*-".split(""), 3, 0, new boolean[3], new String[3], precedences);

		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();

		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}

		long max = 0L;
		for (String[] precedence : this.precedences) {
			long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
			max = Math.max(max, value);
		}

		return max;
	}

	private long calculate(ArrayList<String> tokens, String[] precedence) {
		for (String operator : precedence) { // 우선 순위 연산자부터 먼저 연산하는 방식으로 동작.
			for (int index = 0; index < tokens.size(); index++) {
				if (tokens.get(index).equals(operator)) {
					long left = Long.parseLong(tokens.get(index - 1));
					long right = Long.parseLong(tokens.get(index + 1));
					long result = calculate(left, right, operator);
					tokens.remove(index - 1);
					tokens.remove(index - 1);
					tokens.remove(index - 1);
					tokens.add(index - 1, String.valueOf(result));
					index -= 2;
				}
			}
		}
		return Long.parseLong(tokens.get(0));
	}

	private long calculate(long lhs, long rhs, String op) {
		switch (op) {
			case "+":
				return lhs + rhs;
			case "-":
				return lhs - rhs;
			case "*":
				return lhs * rhs;
			default:
				return 0;
		}
	}
}
