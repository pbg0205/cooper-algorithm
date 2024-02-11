package solved_problem.baekjoon.평범한_배낭_1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// top-down 방식
class Main_TopDown {

	private static Integer[][] dp;
	private static int[] w;
	private static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = reader.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		w = new int[n + 1];
		v = new int[n + 1];
		dp = new Integer[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			String[] split1 = reader.readLine().split(" ");
			w[i] = Integer.parseInt(split1[0]);
			v[i] = Integer.parseInt(split1[1]);
		}

		System.out.println(knapsack(n, k));

		reader.close();
	}

	private static int knapsack(final int i, final int k) {
		// i가 0미만, 즉 범위 밖이 된다면
		if (i < 0)
			return 0;

		// 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
		if (w[i] > k) {
			dp[i][k] = knapsack(i - 1, k);
		}
		// 현재 물건(i)을 담을 수 있는 경우
		else {
			// 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
			int compareWeightIndex = k - w[i];
			dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, compareWeightIndex) + v[i]);
		}

		return dp[i][k];
	}

}
