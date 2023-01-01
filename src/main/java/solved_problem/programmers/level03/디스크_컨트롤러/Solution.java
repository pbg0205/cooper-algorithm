package solved_problem.programmers.level03.디스크_컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int jobIndex = 0;
        int endTime = 0;
        while (count < jobs.length) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= endTime) {
                pq.add(jobs[jobIndex++]);
            }

            if (pq.isEmpty()) {
                endTime = jobs[jobIndex][0];
                continue;
            }

            int[] job = pq.poll();
            answer += job[1] + (endTime - job[0]);
            endTime += job[1];
            count++;
        }

        return Math.floorDiv(answer, jobs.length);
    }
}