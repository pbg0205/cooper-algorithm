package solved_problem.baekjoon.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[n+1][4];
		for (int row = 1; row <= n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= 3; col++) dp[row][col] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i <= n; i++) {
			dp[i][1] += Math.min(dp[i-1][2], dp[i-1][3]);
			dp[i][2] += Math.min(dp[i-1][1], dp[i-1][3]);
			dp[i][3] += Math.min(dp[i-1][1], dp[i-1][2]);
		}

		int min = 1000000000;
		for (int i = 1; i <= 3; i++) if(min > dp[n][i])	min = dp[n][i];

		System.out.println(min);


		br.close();
	}
}
