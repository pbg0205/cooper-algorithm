package solved_problem.baekjoon.ACM호텔_10250;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tc = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < tc; i++) {
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int n = scanner.nextInt();

			if (n % h == 0) {
				System.out.println((h * 100) + (n / h));

			} else {
				System.out.println(((n % h) * 100) + ((n / h) + 1));
			}
		}
	}
}
