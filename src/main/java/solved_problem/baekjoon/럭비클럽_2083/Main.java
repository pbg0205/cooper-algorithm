package solved_problem.baekjoon.럭비클럽_2083;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        while (!(line = scanner.nextLine()).startsWith("# 0 0")) {
            String[] strings = line.split(" ");

            String name = strings[0];
            int age = Integer.parseInt(strings[1]);
            int weight = Integer.parseInt(strings[2]);

            System.out.printf("%s %s \n", name, getClassification(age, weight));
        }
    }

    private static String getClassification(int age, int weight) {
        return ((age > 17) || (weight >= 80)) ? "Senior" : "Junior";
    }

}
