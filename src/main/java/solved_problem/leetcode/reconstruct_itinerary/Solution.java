package solved_problem.leetcode.reconstruct_itinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> fromToMap = buildFromToMap(tickets);
        dfs(result, fromToMap, "JFK");
        return result;
    }

    private void dfs(final List<String> result, final Map<String, PriorityQueue<String>> fromToMap, final String from) {
        PriorityQueue<String> priorityQueue = fromToMap.getOrDefault(from, new PriorityQueue<>());

        while (!priorityQueue.isEmpty()) {
            String next = priorityQueue.poll();
            dfs(result, fromToMap, next);
        }
        result.add(0, from);
    }

    private Map<String, PriorityQueue<String>> buildFromToMap(final List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            fromToMap.putIfAbsent(from, new PriorityQueue<>());
            fromToMap.get(from).add(to);
        }
        return fromToMap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.findItinerary(
            List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"))
        );

        System.out.println("result = " + result);
    }
}
