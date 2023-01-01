package solved_problem.baekjoon.퇴사_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int N;
    private static int max;
    private static Map<Integer, Info> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = toInt(br.readLine());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = toInt(st.nextToken());
            int cost = toInt(st.nextToken());

            map.put(i, new Info(time, cost));
        }

        schedule(0, 0);

        System.out.println(max);

        br.close();
    }

    private static void schedule(int day, int costSum) {
        if (day >= N) {
            max = Math.max(max, costSum);
            return;
        }

        int nowTime = map.get(day).getTime();
        int nowCost = map.get(day).getCost();

        if (day + nowTime <= N) {
            schedule(day + nowTime, costSum + nowCost);
        }

        schedule(day + 1, costSum);
    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }
}

class Info {
    private int time;
    private int cost;

    public Info(int time, int cost) {
        this.time = time;
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }
}
