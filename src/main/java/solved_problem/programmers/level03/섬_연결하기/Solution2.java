package solved_problem.programmers.level03.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 최소 신장 트리(minimum spanning tree) : 간선에 가중치가 있는 그래프에서 간선의 가중치 합이 최소가 되는 트리
 * 크루스칼 알고리즘(kruskal algorithm) : 간선을 가중치 순으로 정렬한 후 순서대로 순회하며 연결되지 않은 두 정점을 잇는 간선을 채택하는 방식
 */

class Solution2 {

    public int solution(int n, int[][] costs) {
        Edge[] edges = Arrays.stream(costs)
                .map(edge -> new Edge(edge[0], edge[1], edge[2]))
                .sorted(Comparator.comparing(e -> e.cost))
                .toArray(Edge[]::new);

        Node[] nodes = new Node[n];
        for (int index = 0; index < n; index++) {
            nodes[index] = new Node();
        }

        int totalCost = 0;
        for (Edge edge : edges) {
            Node node1 = nodes[edge.u];
            Node node2 = nodes[edge.v];

            if (node1.isConnected(node2)) {
                continue;
            }
            node1.merge(node2);
            totalCost += edge.cost;
        }

        return totalCost;
    }

    private static class Node {
        private int depth = 1;
        private Node parent;

        public boolean isConnected(Node other) {
            return root() == other.root();
        }

        public void merge(Node other) {
            if (isConnected(other)) {
                return;
            }

            Node thisRoot = root();
            Node otherRoot = other.root();

            if (thisRoot.depth > otherRoot.depth) {
                otherRoot.parent = thisRoot;
            } else if (thisRoot.depth < otherRoot.depth) {
                thisRoot.parent = otherRoot;
            } else {
                otherRoot.parent = thisRoot;
                thisRoot.depth += 1;
            }
        }

        private Node root() {
            if (parent == null) {
                return this;
            }

            return parent.root();
        }
    }

    private static class Edge {
        private final int u;
        private final int v;
        private final int cost;

        private Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
    }

}
