package solved_problem.leetcode.merge_two_binary_trees;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode resultRoot = new TreeNode();
        dfs(root1, root2, resultRoot);
        return resultRoot;
    }

    private void dfs(TreeNode root1, TreeNode root2, TreeNode result) {
        if (root1 == null && root2 == null) {
            return;
        }

        if (root1 != null) {
            result.val += root1.val;
        }

        if (root2 != null) {
            result.val += root2.val;
        }

        TreeNode root1NextLeft = getNextLeftNode(root1);
        TreeNode root1NextRight = getNextRightNode(root1);

        TreeNode root2NextLeft = getNextLeftNode(root2);
        TreeNode root2NextRight = getNextRightNode(root2);

        if (!(root1NextLeft == null && root2NextLeft == null)) {
            result.left = new TreeNode();
            dfs(root1NextLeft, root2NextLeft, result.left);
        }

        if (!(root1NextRight == null && root2NextRight == null)) {
            result.right = new TreeNode();
            dfs(root1NextRight, root2NextRight, result.right);
        }
    }

    private TreeNode getNextLeftNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return null;
        }

        return node.left;
    }

    private TreeNode getNextRightNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return null;
        }

        return node.right;
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

