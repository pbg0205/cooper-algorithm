package solved_problem.leetcode.task_scheduler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(countMap.values());

        int placeForIdle = pq.poll() - 1;
        int totalIdles = placeForIdle * n;

        while (!pq.isEmpty()) {
            totalIdles -= Math.min(pq.poll(), placeForIdle);
        }

        return totalIdles > 0 ?
                totalIdles + tasks.length : tasks.length;
    }
}
