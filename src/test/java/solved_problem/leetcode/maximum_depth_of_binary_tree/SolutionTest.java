package solved_problem.leetcode.maximum_depth_of_binary_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();
    TreeNode root;


    @BeforeEach
    void setUp() {
        TreeNode node1 = new TreeNode(9, null, null);
        TreeNode node2 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(20, node2, node3);
        root = new TreeNode(3, node1, node4);
    }

    @Test
    @DisplayName("DFS 테스트")
    void dfs() {
        //given
        int expectedResult = 3;

        //when
        int result = solution.maxDepthByDfs(root);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("BFS 테스트")
    void bfs() {
        //given
        int expectedResult = 3;

        //when
        int result = solution.maxDepthByBfs(root);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }
}
