package solved_problem.baekjoon.소수_1312;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int a = SCANNER.nextInt();
        int b = SCANNER.nextInt();
        int count = SCANNER.nextInt();

        int result = a % b;
        for (int index = 0; index < count - 1; index++) {
            result *= 10;
            result %= b;
        }

        result *= 10;

        System.out.println(result / b);
    }

}
