package solved_problem.baekjoon.가장_큰_증가하는_부분_수열_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int [] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());


		int max = 0;
		arr = new int[n+1];
		dp = new int[n+1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int right = 1; right <= n; right++) {
			dp[right] = arr[right];
			for (int left = 1; left <= right; left++) {
				if(arr[left] < arr[right] && dp[right] < dp[left] + arr[right])	dp[right] = dp[left] + arr[right];
				if(max < dp[right])	max = dp[right];
			}
		}
		System.out.println(max);

		br.close();
	}
}
