package solved_problem.baekjoon.이모티콘_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int s;
    static boolean[][] visited = new boolean[2002][2002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        visited[1][0] = true;
        bfs();

        br.close();
    }

    private static void bfs() {
        Queue<smile> queue = new LinkedList<>();
        queue.add(new smile(1, 0, 0));

        while (!queue.isEmpty()) {
            smile se = queue.poll();

            if (se.smileNum == s) {
                System.out.println(se.time);
                return;
            }

            //1.copy
            queue.add(new smile(se.smileNum, se.smileNum, se.time+1));

            //2.paste
            if (se.copyNum != 0 && !visited[se.smileNum + se.copyNum][se.copyNum] && se.smileNum + se.copyNum <= 1000) {
                visited[se.smileNum + se.copyNum][se.copyNum] = true;
                queue.add(new smile(se.smileNum + se.copyNum, se.copyNum, se.time+1));
            }

            //3.제거
            if (se.smileNum > 0 && !visited[se.smileNum - 1][se.copyNum] && se.smileNum - 1 <= 1000)
                queue.add(new smile(se.smileNum - 1, se.copyNum, se.time+1));
        }
    }
}

class smile {
    int smileNum;
    int copyNum;
    int time;

    smile(int smileNum, int copyNum, int time) {
        this.smileNum = smileNum;
        this.copyNum = copyNum;
        this.time = time;
    }
}
