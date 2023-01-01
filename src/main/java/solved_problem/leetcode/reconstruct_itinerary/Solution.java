package solved_problem.leetcode.reconstruct_itinerary;

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs(result, graph, "JFK");
        return result;
    }

    void dfs(LinkedList<String> result, Map<String, PriorityQueue<String>> graph, String from) {
        PriorityQueue<String> destinations = graph.getOrDefault(from, new PriorityQueue<>());

        while (!destinations.isEmpty()) {
            String to = destinations.poll();
            dfs(result, graph, to);
        }

        result.addFirst(from);
    }

    Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> result = new HashMap<>();

        for (List<String> path : tickets) {
            String from = path.get(0);
            String to   = path.get(1);

            result.putIfAbsent(from, new PriorityQueue<>());

            result.get(from).offer(to);
        }

        return result;
    }
}
