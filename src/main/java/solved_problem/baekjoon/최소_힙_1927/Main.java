package solved_problem.baekjoon.최소_힙_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int count = 0; count < numberCount; count++) {
            int number = Integer.parseInt(reader.readLine());
            if (number != 0) {
                priorityQueue.add(number);
            }

            if (number == 0) {
                int result = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
                System.out.println(result);
            }
        }
    }

}
