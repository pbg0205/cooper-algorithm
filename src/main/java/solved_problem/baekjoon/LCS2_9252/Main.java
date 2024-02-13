package solved_problem.baekjoon.LCS2_9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = reader.readLine().toCharArray();
		char[] str2 = reader.readLine().toCharArray();
		dp = new int[str1.length + 1][str2.length + 1];

		lcsByDp(str1, str2);
		String answer = toAnswer(str1, str1.length, str2.length);

		System.out.println(dp[str1.length][str2.length]);
		System.out.println(answer);

		reader.close();
	}

	private static void lcsByDp(char[] a, char[] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == (b[j])) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
	}

	static String toAnswer(char[] str, int i, int j) {
		StringBuilder sb = new StringBuilder();

		Stack<Character> st = new Stack<>();
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				st.push(str[i-1]);
				i--;
				j--;
			}
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return sb.toString();
	}
}
