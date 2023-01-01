package solved_problem.programmers.level02.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Work> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Work(progresses[i], speeds[i]));
        }

        int days = 1;

        while (!queue.isEmpty()) {
            int cnt = 0;
            while (!queue.isEmpty()) {
                Work work = queue.peek();
                if (!work.isDone(days)) {
                    break;
                }
                queue.poll();
                cnt++;
            }

            if (cnt > 0) {
                answerList.add(cnt);
            }
            days++;
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}

class Work {
    private int progress;
    private int speed;

    Work(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public boolean isDone(int days) {
        return this.progress + (days * speed) >= 100;
    }
}