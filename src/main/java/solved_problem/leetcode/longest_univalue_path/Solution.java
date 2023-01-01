package solved_problem.leetcode.longest_univalue_path;

class Solution {
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);

        int leftSum = 0;
        int rightSum = 0;

        if (node.left != null && node.left.val == node.val) {
            leftSum += leftLength + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            rightSum = rightLength + 1;
        }

        result = Math.max(result, leftSum + rightSum);
        return Math.max(leftSum, rightSum);
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
