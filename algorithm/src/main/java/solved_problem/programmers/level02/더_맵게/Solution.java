package java.solved_problem.programmers.level02.더_맵게;

import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++)
            pq.offer(scoville[i]);

        while(pq.size() > 1) {
            if(pq.peek() >= K)
                break;

            int low_first = pq.poll();
            int low_second = pq.poll();

            int scoville_result = low_first + (low_second * 2);
            pq.offer(scoville_result);

            answer++;
        }

        if(pq.poll() >= K)
            return answer;

        return -1;
    }
}