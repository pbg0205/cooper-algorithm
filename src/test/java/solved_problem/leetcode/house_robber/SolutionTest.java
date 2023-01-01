package solved_problem.leetcode.house_robber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    private Solution solution;
    private int[] nums;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void robTest1() {
        //given
        nums = new int[]{1, 2, 3, 1};
        int expected = 4;

        //when
        int result = solution.rob(nums);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
