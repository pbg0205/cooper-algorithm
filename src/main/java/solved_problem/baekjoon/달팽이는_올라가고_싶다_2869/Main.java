package solved_problem.baekjoon.달팽이는_올라가고_싶다_2869;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int A = SCANNER.nextInt();
        int B = SCANNER.nextInt();
        int V = SCANNER.nextInt();

        int days = getDaysClimbingStick(A, B, V);
        System.out.println(days);
    }

    /**
     * - 위에서 부터 생각해서 아래로 내려가는 방법에 대해 생각하면 간단한 문제
     * - 만약 나눈 값이 존재하면 하루를 더하는 방식으로 연산
     */
    private static int getDaysClimbingStick(int up, int down, int length) {
        int stepsPerDay = up - down;
        int days = (length - down) / stepsPerDay;

        return ((length - down) % stepsPerDay > 0) ? (days + 1) : days;
    }

}
