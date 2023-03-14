package solved_problem.leetcode.sum_root_to_leaf_numbers;

class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    private void preOrder(TreeNode node, int number) {
        if (isLeafNode(node)) {
            sum += (number * 10) + node.val;
            return;
        }

        if (!(node.left == null)) {
            preOrder(node.left, (number * 10) + node.val);
        }

        if (!(node.right == null)) {
            preOrder(node.right, (number * 10) + node.val);
        }

    }

    private boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    static class TreeNode {
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

}
