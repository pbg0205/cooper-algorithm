package solved_problem.baekjoon.집합의_표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int index = 1; index <= n; index++) {
            parent[index] = index;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < m; index++) {
            st = new StringTokenizer(br.readLine());
            int operand = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (operand == 0) {
                unionParent(parent, x, y);
            } else if (operand == 1) {
                int parentX = findParent(parent, x);
                int parentY = findParent(parent, y);

                stringBuilder.append(((parentX == parentY) ? "YES" : "NO") + "\n");
            }

        }

        bw.write(stringBuilder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void unionParent(int[] parent, int x, int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);

        if (x == y) {
            return;
        }

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }

    private static int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent, parent[x]);
    }

}
