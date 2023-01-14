package solved_problem.baekjoon.부호_1247;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = 3;
        for (int testCount = 0; testCount < testCase; testCount++) {
            System.out.println(calculateSign());
        }
    }

    private static String calculateSign() {
        BigInteger bigIntegerSum = BigInteger.ZERO;
        int N = Integer.parseInt(scanner.nextLine());

        for (int number = 0; number < N; number++) {
            BigInteger bigInteger = BigInteger.valueOf(Long.parseLong(scanner.nextLine()));
            bigIntegerSum = bigIntegerSum.add(bigInteger);
        }

        return determineSign(bigIntegerSum);
    }

    private static String determineSign(BigInteger sum) {
        if (sum.signum() == 1) {
            return "+";
        }

        if (sum.signum() == -1) {
            return "-";
        }

        return "0";
    }

}
