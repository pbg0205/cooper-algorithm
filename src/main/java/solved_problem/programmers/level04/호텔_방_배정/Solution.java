package solved_problem.programmers.level04.호텔_방_배정;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public long[] solution(long k, long[] room_number) {
        List<Long> assigned = new ArrayList<>();
        Map<Long, Node> nodes = new HashMap<>();

        for (long number : room_number) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }

            Node node = new Node(number);
            nodes.put(number, node);
            if (nodes.containsKey(number - 1)) {
                node.merge(nodes.get(number - 1));
            }
            if (nodes.containsKey(number + 1)) {
                node.merge(nodes.get(number + 1));
            }

            assigned.add(number);
        }

        return assigned.stream()
                .mapToLong(Long::valueOf)
                .toArray();
    }

    private static class Node {
        private int depth = 1;
        private Node parent;

        private long max;

        public Node(long value) {
            this.max = value;
        }

        public Node root() {
            if (parent == null) {
                return this;
            }
            return parent = parent.root();
        }

        public boolean isConnected(Node other) {
            return this.root() == other.root();
        }

        public void merge(Node other) {
            if (isConnected(other)) {
                return;
            }

            Node thisRoot = this.root();
            Node otherRoot = other.root();

            if (thisRoot.depth > otherRoot.depth) {
                otherRoot.parent = thisRoot;
            } else if (thisRoot.depth < otherRoot.depth) {
                thisRoot.parent = otherRoot;
            } else {
                otherRoot.parent = thisRoot;
                thisRoot.depth += 1;
            }

            thisRoot.max = Math.max(thisRoot.max, otherRoot.max);
            otherRoot.max = thisRoot.max;
        }

        public long max() {
            return root().max;
        }
    }
}
