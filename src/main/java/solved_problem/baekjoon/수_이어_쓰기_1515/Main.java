package solved_problem.baekjoon.수_이어_쓰기_1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int inputIndex = 0;
        int n = 0;

        while (n++ <= 3000) {
            String temp = String.valueOf(n);
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == input.charAt(inputIndex)) {
                    inputIndex++;
                }

                if (inputIndex == input.length()) {
                    System.out.println(n);
                    return;
                }
            }
        }

        reader.close();
    }

}
