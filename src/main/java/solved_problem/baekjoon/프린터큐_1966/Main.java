package solved_problem.baekjoon.프린터큐_1966;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(SCANNER.nextLine());

        for (int test = 0; test < testcase; test++) {
            String[] splited = SCANNER.nextLine().split(" ");
            int N = Integer.parseInt(splited[0]);
            int M = Integer.parseInt(splited[1]);

            List<Integer> numbers = Arrays.stream(SCANNER.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            solve(M, numbers);
        }
    }

    private static void solve(int m, List<Integer> priorities) {
        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int count = 0;
        for (int index = 0; index < priorities.size(); index++) {
            int priority = priorities.get(index);
            queue.add(new Document(index, priority));
            priorityQueue.add(-priority);
        }

        while (!queue.isEmpty()) {
            int priority = priorityQueue.peek();
            Document document = queue.poll();
            if (document.getPriority() == -priority) {
                priorityQueue.poll();
                count += 1;
                if (document.getIndex() == m) {
                    System.out.println(count);
                    return;
                }
            } else {
                queue.add(document);
            }
        }

    }
    static class Document {
        private int index;
        private int priority;

        public Document(int index, int priority) {
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
}
