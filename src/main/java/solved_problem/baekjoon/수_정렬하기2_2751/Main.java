package solved_problem.baekjoon.수_정렬하기2_2751;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int numberCount = Integer.parseInt(SCANNER.nextLine());
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < numberCount; index++) {
            numbers.add(Integer.parseInt(SCANNER.nextLine()));
        }

        Collections.sort(numbers);


        String answer = numbers.stream().map(String::valueOf).collect(Collectors.joining("\n", "", ""));
        System.out.println(answer);
    }

}
