package solved_problem.baekjoon.바이러스_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodeSize = Integer.parseInt(br.readLine());
        int linkCount = Integer.parseInt(br.readLine());

        boolean[] infected = new boolean[nodeSize + 1];
        Map<Integer, List<Integer>> virusMap = new HashMap<>();

        for (int index = 1; index <= nodeSize; index++) {
            virusMap.put(index, new ArrayList<>());
        }

        for (int index = 1; index <= linkCount; index++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            virusMap.get(first).add(second);
            virusMap.get(second).add(first);
        }

        System.out.println(bfs(1, infected, virusMap));
    }

    private static int bfs(int start, boolean[] infected, Map<Integer, List<Integer>> virusMap) {
        int infectedCount = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        infected[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> linkedIndexes = virusMap.get(index);

            for (Integer linkedIndex : linkedIndexes) {
                if (!infected[linkedIndex]) {
                    queue.add(linkedIndex);
                    infected[linkedIndex] = true;
                    infectedCount += 1;
                }
            }
        }

        return infectedCount;
    }

}
