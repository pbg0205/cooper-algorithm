package solved_problem.leetcode.invert_binary_tree;


class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * - Runtime: 0 ms, faster than 100.00% of Java
     * - Memory Usage: 36.3 MB, less than 73.56% of Java
     */
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;

        dfs(node.left);
        dfs(node.right);
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
