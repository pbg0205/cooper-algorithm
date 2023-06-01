package solved_problem.baekjoon.듣보잡_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int unListenableCount = Integer.parseInt(tokenizer.nextToken());
        int unSeenCount = Integer.parseInt(tokenizer.nextToken());

        Set<String> unListenableNameSet = new HashSet<>();
        for (int count = 0; count < unListenableCount; count++) {
            unListenableNameSet.add(reader.readLine());
         }

        Set<String> answerSet = new HashSet<>();
        for (int count = 0; count < unSeenCount; count++) {
            String unSeenPersonName = reader.readLine();
            if (unListenableNameSet.contains(unSeenPersonName)) {
                answerSet.add(unSeenPersonName);

            }
        }

        System.out.println(answerSet.size());
        System.out.println(answerSet.stream().sorted().collect(Collectors.joining("\n")));
    }

}
