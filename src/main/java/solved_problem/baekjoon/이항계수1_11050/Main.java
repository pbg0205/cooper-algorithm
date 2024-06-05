package solved_problem.baekjoon.이항계수1_11050;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 1;
		int n = sc.nextInt();
		int r = sc.nextInt();

		for(int i = 1; i <= r; i++)	result *= (n - i + 1);
		for(int i = r; i > 0;i--)	result /= i;

		System.out.println(result);

		sc.close();
	}
}
