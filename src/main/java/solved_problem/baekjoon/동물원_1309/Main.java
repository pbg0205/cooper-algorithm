package solved_problem.baekjoon.동물원_1309;

import java.util.Scanner;

class Main {
	static final int div= 9901;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int sum = 0;
		dp = new int[4][n+1];

		dp[1][1] = dp[2][1] = dp[3][1] = 1;

		for (int col = 2; col <= n; col++) {
			dp[1][col] = (dp[2][col-1] + dp[3][col-1]) % div;
			dp[2][col] = (dp[1][col-1] + dp[3][col-1]) % div;
			dp[3][col] = (dp[1][col-1] + dp[2][col-1] + dp[3][col-1]) % div;
		}

		sum = dp[1][n] + dp[2][n] + dp[3][n];
		System.out.println(sum % div);


		sc.close();
	}
}
