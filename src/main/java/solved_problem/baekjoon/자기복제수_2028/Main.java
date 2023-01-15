package solved_problem.baekjoon.자기복제수_2028;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(Integer.parseInt(scanner.nextLine()));
        }

        for (Integer input : inputs) {
            String answer = getSelfReplicationNumberAnswer(input);
            System.out.println(answer);
        }

    }

    private static boolean isSelfReplicationNumber(int number) {
        int numberSquare = number * number;

        int numberDigit = (int) Math.log10(number) + 1;
        int numberSquareDigit = (int) Math.log10(numberSquare) + 1;

        int startIndex = numberSquareDigit - numberDigit;

        String compareNumber = String.valueOf(numberSquare).substring(startIndex, numberSquareDigit);

        return String.valueOf(number).equals(compareNumber);
    }

    private static String getSelfReplicationNumberAnswer(Integer input) {
        return isSelfReplicationNumber(input) ? "YES" : "NO";
    }

}
