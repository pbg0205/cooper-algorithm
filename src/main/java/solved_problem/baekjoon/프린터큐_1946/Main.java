package solved_problem.baekjoon.프린터큐_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int requiredIdx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int index = 0;
            while (st.hasMoreElements()) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Node(index++, priority));
                pq.add(priority);
            }

            int pollCount = 1;
            while (!q.isEmpty()) {
                Node pollNode = q.poll();
                if (pollNode.getPriority() != pq.peek()) {
                    q.add(pollNode);
                    continue;
                }

                if (pollNode.getIndex() == requiredIdx) {
                    System.out.println(pollCount);
                    break;
                }
                pollCount++;
                pq.poll();
            }

            q.clear();
            pq.clear();
        }

        br.close();
    }
}

class Node {
    private int index;
    private int priority;

    public Node(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}