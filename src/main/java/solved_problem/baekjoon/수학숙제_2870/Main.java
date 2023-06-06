package solved_problem.baekjoon.수학숙제_2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<BigInteger> answerNumbers = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("[a-z]{1,100}");
            List<BigInteger> numbers = Arrays.stream(split)
                    .filter(line -> line.length() > 0)
                    .map(BigInteger::new)
                    .collect(Collectors.toList());
            answerNumbers.addAll(numbers);
        }

        answerNumbers.sort(Comparator.naturalOrder());

        String answer = answerNumbers.stream().map(String::valueOf).collect(Collectors.joining("\n"));
        System.out.println(answer);
    }

}
