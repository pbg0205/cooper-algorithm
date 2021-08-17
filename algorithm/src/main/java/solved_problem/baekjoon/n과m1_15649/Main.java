package solved_problem.baekjoon.n과m1_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];

        rec_func(1);
        System.out.println(sb.toString());

        br.close();
    }

    private static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            boolean isUsed = false;
            for (int i = 0; i < k; i++) {
                if (cand == selected[i]) {
                    isUsed = true;
                }

                if (!isUsed) {
                    selected[k] = cand;
                    rec_func(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }
}
