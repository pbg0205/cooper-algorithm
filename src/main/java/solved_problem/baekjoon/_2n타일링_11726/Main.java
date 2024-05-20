package solved_problem.baekjoon._2n타일링_11726;

import java.util.Scanner;

public class Main {

	static int[] d = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(dp(n));




		sc.close();
	}

	public static int dp(int n) {
		if(n == 1)	return d[1] = 1;
		if(n == 2)	return d[2] = 2;
		if(d[n] > 0) {
			return d[n];
		}else {
			return d[n] = (dp(n-1) + dp(n-2)) % 10007;
		}
	}
}
