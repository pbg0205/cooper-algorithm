package solved_problem.baekjoon.피보나치수5_10870;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(recur(n));

        scanner.close();
    }

    private static int recur(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return recur(n - 1) + recur(n - 2);
    }
}
