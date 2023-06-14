package solved_problem.programmers.level02.행렬의_곱셈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test() {
        //given
        int[][] arr1 = new int[][] {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = new int[][] {{3, 3}, {3, 3}};
        int[][] result = new int[][] {{15, 15}, {15, 15}, {15, 15}};

        //when
        int[][] actual = solution.solution(arr1, arr2);

        //then
        assertThat(actual).isEqualTo(result);
    }

}
