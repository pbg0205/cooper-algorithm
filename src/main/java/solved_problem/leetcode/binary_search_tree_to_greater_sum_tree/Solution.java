package solved_problem.leetcode.binary_search_tree_to_greater_sum_tree;

class Solution {

    private int val = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            //right
            bstToGst(root.right);

            //root
            val += root.val;
            root.val = val;

            //left
            bstToGst(root.left);
        }
        return root;
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
