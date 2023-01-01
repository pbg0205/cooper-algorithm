package solved_problem.leetcode.range_sum_of_bst;

/**
 * - Runtime: 0 ms, faster than 100.00% of Java online
 * - Memory Usage: 64 MB, less than 11.07% of Java online
 */

class Solution {
    private int low;
    private int high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.val < low) {
            return dfs(root.right);
        }

        if (root.val > high) {
            return dfs(root.left);
        }

        return root.val + dfs(root.left) + dfs(root.right);
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
