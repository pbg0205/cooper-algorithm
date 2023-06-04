package solved_problem.baekjoon.OX퀴즈_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int answer = calculateScore(reader.readLine());
            builder.append(answer).append("\n");
        }

        System.out.println(builder);
        reader.close();
    }

    private static int calculateScore(String answers) {
        int score = 0;
        int correctCount = 0;

        for (char answer : answers.toCharArray()) {
            if (answer == 'O') {
                correctCount += 1;
                score += correctCount;
                continue;
            }

            correctCount = 0;
        }

        return score;
    }

}
