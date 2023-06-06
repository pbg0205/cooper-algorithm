package solved_problem.baekjoon.농구_경기_1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> firstAlphabetMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String firstAlphabet = reader.readLine().substring(0, 1);
            firstAlphabetMap.put(firstAlphabet, firstAlphabetMap.getOrDefault(firstAlphabet, 0) + 1);
        }

        List<String> firstAlphabetList = new ArrayList<>();
        for (Map.Entry<String, Integer> characterIntegerEntry : firstAlphabetMap.entrySet()) {
            int firstAlphaFrequency = characterIntegerEntry.getValue();
            if (firstAlphaFrequency >= 5) {
                firstAlphabetList.add(characterIntegerEntry.getKey());
            }
        }

        String answer = firstAlphabetList.size() > 0 ?
                firstAlphabetList.stream().collect(Collectors.joining("")) : "PREDAJA";

        System.out.println(answer);

        reader.close();
    }

}
