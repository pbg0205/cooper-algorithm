package solved_problem.leetcode.sum_root_to_leaf_numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void preOrder1() {
        //given
        Solution.TreeNode leftNode = new Solution.TreeNode(2, null, null);
        Solution.TreeNode rightNode = new Solution.TreeNode(3, null, null);
        Solution.TreeNode rootNode = new Solution.TreeNode(1, leftNode, rightNode);

        //when
        int sum = solution.sumNumbers(rootNode);

        //then
        assertThat(sum).isEqualTo(25);
    }

    @Test
    void preOrder2() {
        //given
        Solution.TreeNode leftNode = new Solution.TreeNode(1, null, null);
        Solution.TreeNode rootNode = new Solution.TreeNode(0, leftNode, null);

        //when
        int sum = solution.sumNumbers(rootNode);

        //then
        assertThat(sum).isEqualTo(1);
    }

}
