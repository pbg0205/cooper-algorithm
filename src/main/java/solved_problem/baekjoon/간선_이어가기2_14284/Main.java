package solved_problem.baekjoon.간선_이어가기2_14284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int distance[];
    private static List<List<Vertex>> graph = new ArrayList<>();

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        distance = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M ; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());

            graph.get(start).add(new Vertex(end,cost));
            graph.get(end).add(new Vertex(start,cost));
        }

        tokenizer = new StringTokenizer(reader.readLine());

        int start = Integer.parseInt(tokenizer.nextToken());
        int target= Integer.parseInt(tokenizer.nextToken());

        System.out.println(solution(start,target));
    }


    static int solution(int start,int target){
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Vertex(start,0));

        distance[start] = 0;

        while(!queue.isEmpty()){
            Vertex now = queue.poll();

            for(Vertex next : graph.get(now.v)){
                int nextCostAccumulation = distance[now.v] + next.cost;
                if(distance[next.v] > nextCostAccumulation){
                    distance[next.v] = nextCostAccumulation;
                    queue.add(new Vertex(next.v, distance[next.v]));
                }
            }
        }

        return distance[target];
    }

    private static class Vertex{
        private int v;
        private int cost;

        public Vertex(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }

}
