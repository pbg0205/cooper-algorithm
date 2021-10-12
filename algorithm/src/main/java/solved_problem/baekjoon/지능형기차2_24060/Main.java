package solved_problem.baekjoon.지능형기차2_24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            queue.offer(in - out);
        }

        int max = Integer.MIN_VALUE;
        int nowPassenger = 0;
        while (!queue.isEmpty()) {
            nowPassenger += queue.poll();
            max = Math.max(max, nowPassenger);
        }

        System.out.println(max);

        br.close();
    }
}
