package solved_problem.leetcode.minimum_height_trees;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return new ArrayList<Integer>(){{
                add(0);
            }};
        }

        Map<Integer, List<Integer>> map = initMap(edges);
        List<Integer> leaves = initLeaves(map);

        while (n > 2) {
            n -= leaves.size();
            leaves = removeLeaves(map, leaves);
        }

        return leaves;
    }

    private List<Integer> removeLeaves(Map<Integer, List<Integer>> map, List<Integer> leaves) {
        List<Integer> newLeaves = new ArrayList<>();

        for (Integer node : leaves) {
            map.get(node).forEach(neighbor -> {
                map.get(neighbor).remove(node);

                if (map.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            });
        }

        return newLeaves;
    }

    private List<Integer> initLeaves(Map<Integer, List<Integer>> map) {
        return map.entrySet().stream()
                .filter(edge -> edge.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> initMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            map.putIfAbsent(from, new ArrayList<>());
            map.putIfAbsent(to, new ArrayList<>());

            map.get(from).add(to);
            map.get(to).add(from);
        }

        return map;
    }
}
