package solved_problem.baekjoon.평범한_배낭_1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// bottom-up 방식
class Main_BottomUp {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = reader.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			String[] split1 = reader.readLine().split(" ");
			w[i] = Integer.parseInt(split1[0]);
			v[i] = Integer.parseInt(split1[1]);
		}

		/**
		 * i : 0번 인덱스 부터 탐색하는 인덱스 위치
		 * j : 수용 가능한 배낭 무게
		 * 1개 무게 합 -> 2개 무게 합 -> 3개 무게 합 비교
		 */
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				int preValueSum = dp[i - 1][j];

				if (w[i] > j) {
					dp[i][j] = preValueSum;
					continue;
				}

				int compareWeightIndex = j - w[i];
				int compareValueSum = dp[i - 1][compareWeightIndex] + v[i];

				dp[i][j] = Math.max(preValueSum, compareValueSum);
			}
		}

		System.out.println(dp[n][k]);

		reader.close();
	}

}
