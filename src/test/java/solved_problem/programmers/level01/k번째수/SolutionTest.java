package solved_problem.programmers.level01.k번째수;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final SolutionInterface solution = new Solution3();

    @Test
    void test() {
        //given
        int[] arr = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //when
        int[] actual = solution.solution(arr, commands);

        //then
        assertThat(actual).isEqualTo(new int[]{5, 6, 3});
    }

}
