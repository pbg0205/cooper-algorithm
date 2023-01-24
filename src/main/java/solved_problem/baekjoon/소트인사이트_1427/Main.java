package solved_problem.baekjoon.소트인사이트_1427;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String numberStr = SCANNER.nextLine();
        List<Character> numberChars = new ArrayList<>();
        for (char numberChar : numberStr.toCharArray()) {
            numberChars.add(numberChar);
        }

        numberChars.sort(Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (Character numberChar : numberChars) {
            stringBuilder.append(numberChar);
        }

        System.out.println(stringBuilder);
    }

}
