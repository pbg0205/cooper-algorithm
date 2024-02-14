package solved_problem.baekjoon.lcs_1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String a = reader.readLine();
		String b = reader.readLine();
		String c = reader.readLine();

		int result = lcs(a, b, c);

		System.out.println(result);

		reader.close();
	}

	public static int lcs(String a, String b, String c) {

		int[][][] dp = new int[a.length() + 1][b.length() + 1][c.length() + 1];

		for (int i = 1; i <= a.length(); i++) {
			char ch1 = a.charAt(i - 1);

			for (int j = 1; j <= b.length(); j++) {
				char ch2 = b.charAt(j - 1);

				for (int k = 1; k <= c.length(); k++) {
					char ch3 = c.charAt(k - 1);

					if (ch1 == ch2 && ch2 == ch3) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
						continue;
					}

					dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));

				}
			}
		}

		return dp[a.length()][b.length()][c.length()];

	}
}
