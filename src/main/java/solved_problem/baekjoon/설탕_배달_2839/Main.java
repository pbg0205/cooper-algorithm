package solved_problem.baekjoon.설탕_배달_2839;

import java.util.Scanner;

 class Main {

	public static void main(String...agrs) {

		Scanner scan = new Scanner(System.in);

		int sugar = Integer.parseInt(scan.nextLine());

		int a = 0, b = 0;

		for(b = sugar/5; b >= -1; b--) {
			if((sugar- 5 * b) % 3 == 0) {
				a = (sugar- 5 * b) / 3;
				break;
			}

		}

		if(b == -1) {
			System.out.print(b);
		}else {
			System.out.println(a + b);
		}

		scan.close();
	}

}
