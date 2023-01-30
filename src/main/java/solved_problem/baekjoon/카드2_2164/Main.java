package solved_problem.baekjoon.카드2_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Queue 기본 문제
     */
    public static void main(String[] args) {
        int N = SCANNER.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int number = 1; number <= N; number++) {
            queue.add(number);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }

}
