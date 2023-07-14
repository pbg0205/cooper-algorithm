package solved_problem.baekjoon.소트인사이드_1427;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.nextLine();
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
