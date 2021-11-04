package solved_problem.programmers.level03.이중우선순위_큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> maxPriority = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPriority = new PriorityQueue<>();

        for (String operation : operations) {
            String[] split = operation.split(" ");

            if (split[0].equals("D")) {
                if (split[1].equals("1")) {
                    Integer max = maxPriority.poll();
                    minPriority.remove(max);
                } else {
                    Integer min = minPriority.poll();
                    maxPriority.remove(min);
                }
            }

            if (split[0].equals("I")) {
                int number = Integer.parseInt(split[1]);
                maxPriority.add(number);
                minPriority.add(number);
            }
        }

        int max = Integer.MIN_VALUE;
        while (!maxPriority.isEmpty()) {
            Integer poll = maxPriority.poll();
            max = poll;
            break;
        }

        int min = Integer.MIN_VALUE;
        while (!minPriority.isEmpty()) {
            Integer poll = minPriority.poll();
            min = poll;
            break;
        }

        if (max != Integer.MIN_VALUE && min != Integer.MAX_VALUE) {
            return new int[]{max, min};
        }

        return new int[]{0, 0};
    }
}
