package solved_problem.leetcode.balanced_binary_tree;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return !(dfs(root) == -1);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = dfs(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDifference = Math.abs(leftHeight - rightHeight);
        if (heightDifference <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return -1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
