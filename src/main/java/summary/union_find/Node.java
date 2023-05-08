package summary.union_find;

class Node {

    private int depth = 1;
    private Node parent;

    public boolean isConnected(Node other) {
        return root() == other.root();
    }

    private Node root() {
        if (parent == null) {
            return this;
        }
        return parent = parent.root();
    }

    public void merge(Node other) {
        if (isConnected(other)) {
            return;
        }

        Node root1 = root();
        Node root2 = other.root();

        if (root1.depth > root2.depth) {
            root2.parent = root1;
        } else if (root1.depth < root2.depth) {
            root1.parent = root2;
        } else {
            root2.parent = root1;
            root1.depth += 1;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();

        boolean connectedBeforeMerge = node1.isConnected(node2);
        System.out.println("connectedBeforeMerge = " + connectedBeforeMerge);

        node1.merge(node2);

        boolean connectedAfterMerge = node1.isConnected(node2);
        System.out.println("connectedAfterMerge = " + connectedAfterMerge);
    }

}
