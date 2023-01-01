package solved_problem.leetcode.minimum_distance_between_bst_nodes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static void inOrder(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }
    public int minDiffInBST(TreeNode root) {
        if(root == null)
            return 0;

        List<Integer> al = new ArrayList<>();

        inOrder(root, al);

        int min_diff = Integer.MAX_VALUE;

        for(int i=0; i<al.size()-1; i++){
            min_diff = Math.min(min_diff, al.get(i+1) - al.get(i));
        }
        return min_diff;
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
