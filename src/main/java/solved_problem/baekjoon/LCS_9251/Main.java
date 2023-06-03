package solved_problem.baekjoon.LCS_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();

        int[][] dp = new int[1001][1001];

        for (int sIdx = 0; sIdx < s.length(); sIdx++) {
            for (int tIdx = 0; tIdx < t.length(); tIdx++) {
                if (s.charAt(sIdx) == t.charAt(tIdx)) {
                    dp[sIdx + 1][tIdx + 1] = dp[sIdx][tIdx] + 1;
                } else {
                    dp[sIdx + 1][tIdx + 1] = Math.max(dp[sIdx][tIdx + 1], dp[sIdx + 1][tIdx]);
                }
            }
        }

        System.out.println(dp[s.length()][t.length()]);

        reader.close();
    }

}
