package solved_problem.baekjoon.Four_Squares_17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		solve(dp, n);
		System.out.println(dp[n]);
	}

	private static void solve(int[] dp, int n) {
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; (j * j) <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;
		}
	}
}
