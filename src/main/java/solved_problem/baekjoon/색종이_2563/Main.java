package solved_problem.baekjoon.색종이_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int total = 0;
        boolean[][] check = new boolean[101][101];

        for (int tc = 0; tc < n; tc++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (!check[i][j]) {
                        check[i][j] = true;
                        total++;
                    }
                }
            }

        }

        System.out.println(total);
        reader.close();
    }

}
