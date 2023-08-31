package solved_problem.baekjoon.한수_1065;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int hansuCount = 0;

        for (int i = 1; i <= input; i++) {
            if (i < 100) {
                hansuCount++;
                continue;
            }

            String number = String.valueOf(i);
            int d = number.charAt(1) - number.charAt(0);
            boolean isHansu = true;

            for (int j = 0; j < number.length() - 1; j++) {
                if (number.charAt(j + 1) - number.charAt(j) != d) {
                    isHansu = false;
                    break;
                }
            }

            if (isHansu) {
                hansuCount++;
            }

        }

        System.out.println(hansuCount);

        scanner.close();
    }

}
