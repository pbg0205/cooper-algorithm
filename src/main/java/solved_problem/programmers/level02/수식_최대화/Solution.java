package solved_problem.programmers.level02.수식_최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	private String[][] precedences = new String[][] {
	  "+*-".split(""),
	  "+-*".split(""),
	  "*+-".split(""),
	  "*-+".split(""),
	  "-*+".split(""),
	  "-+*".split("")
	};

	public long solution(String expression) {
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();

		while (tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}

		long max = 0L;
		for (String[] precedence : precedences) {
			long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
			max = Math.max(max, value);
		}

		return max;
	}

	private long calculate(ArrayList<String> tokens, String[] precedence) {
		for (String operator : precedence) {
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
