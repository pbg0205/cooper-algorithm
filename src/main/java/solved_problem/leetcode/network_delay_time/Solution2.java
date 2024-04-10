package solved_problem.leetcode.network_delay_time;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Solution2 {
	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] time : times) {
			int from = time[0];
			int to = time[1];
			int weight = time[2];

			graph.putIfAbsent(from, new HashMap<>());
			graph.get(from).put(to, weight);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
		pq.add(new AbstractMap.SimpleEntry<>(k, 0));

		Map<Integer, Integer> distances = new HashMap<>();

		while (!pq.isEmpty()) {
			Map.Entry<Integer, Integer> currentEntry = pq.poll();
			Integer currentVertex = currentEntry.getKey();
			Integer currentWeight = currentEntry.getValue();

			// bfs 형태로 조회하는 방식
			if (!distances.containsKey(currentVertex)) {
				distances.put(currentVertex, currentWeight);

				if (graph.containsKey(currentVertex)) {
					for (Map.Entry<Integer, Integer> entry : graph.get(currentVertex).entrySet()) {
						Integer nextWeight = entry.getValue();
						int distanceSum = currentWeight + nextWeight;
						pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), distanceSum));
					}
				}
			}
		}

		if (distances.size() == n) {
			return Collections.max(distances.values());
		} else {
			return -1;
		}
	}
}
