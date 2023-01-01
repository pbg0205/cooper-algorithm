package solved_problem.programmers.level02.프린트;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] properties, int location) {
        int answer = 0;

        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < properties.length; i++) {
            int index = i;
            int priority = properties[i];
            queue.add(new Document(index, priority));
            priorityQueue.add(priority);
        }

        while (!queue.isEmpty()) {
            Document document = queue.poll();
            int priority = document.getPriority();

            if (!(priority == priorityQueue.peek())) {
                queue.add(document);
                continue;
            }

            answer++;
            priorityQueue.poll();

            if (document.getIndex() == location) {
                break;
            }
        }
        return answer;
    }
}

class Document {
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