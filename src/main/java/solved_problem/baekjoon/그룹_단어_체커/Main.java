package solved_problem.baekjoon.그룹_단어_체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int answer = 0;
        for (int idx = 0; idx < n; idx++) {
            String word = reader.readLine();
            answer += checkGroupWordChecker(word);
        }

        System.out.println(answer);
    }

    private static int checkGroupWordChecker(String word) {
        char previousAlphabet = '-';
        boolean[] visited = new boolean[ALPHABET_SIZE];

        for (char alphabet : word.toCharArray()) {
            int alphabetIndex = alphabet - 'a';
            if (alphabet == previousAlphabet) {
                continue;
            }

            if (alphabet != previousAlphabet && !visited[alphabetIndex]) {
                previousAlphabet = alphabet;
                visited[alphabetIndex] = true;
                continue;
            }

            return 0;
        }

        return 1;
    }

}
