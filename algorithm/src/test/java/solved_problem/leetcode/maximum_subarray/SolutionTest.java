package solved_problem.leetcode.maximum_subarray;

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
    void test01() {
        //given
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        //when
        int result = solution.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void test02() {
        //given
        nums = new int[]{-1};

        //when
        int result = solution.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void test03() {
        //given
        nums = new int[]{-1, -2};

        //when
        int result = solution.maxSubArray(nums);

        //then
        assertThat(result).isEqualTo(-1);
    }
}
