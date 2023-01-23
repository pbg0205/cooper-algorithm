package solved_problem.baekjoon.뒤집힌_덧셈_1357;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String X = SCANNER.next();
        String Y = SCANNER.next();

        int revX = Integer.parseInt(reverse(X));
        int revY = Integer.parseInt(reverse(Y));

        String result = reverse(String.valueOf(revX + revY));
        System.out.println(Integer.parseInt(result));

    }

    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int index = chars.length - 1; index >= 0; index--) {
            sb.append(chars[index]);
        }

        return sb.toString();
    }

}
