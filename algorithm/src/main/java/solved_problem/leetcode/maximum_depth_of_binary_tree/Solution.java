package solved_problem.leetcode.maximum_depth_of_binary_tree;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int maxDepth = 1;

    public int maxDepth(TreeNode root) {
        return maxDepthByDfs(root);
    }

    /**
     * 1. DFS 풀이법
     * - Runtime: 0 ms, faster than 100.00% of Java online
     * - Memory Usage: 38.6 MB, less than 88.33% of Java online
     */
    public int maxDepthByDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }

        if (root.right != null) {
            dfs(root.right, depth + 1);
        }

        return maxDepth;
    }

    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
            return;
        }

        if (node.left != null) {
            dfs(node.left, depth + 1);
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }


    /**
     * 2. BFS 풀이법
     * - Runtime: 1 ms, faster than 14.00% of Java online
     * - Memory Usage: 38.6 MB, less than 88.33% of Java online
     */
    public int maxDepthByBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth += 1;

            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
