package solved_problem.programmers.level01.푸드_파이트_대회;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        //given
        final int[] food = new int[]{1, 3, 4, 6};

        //when
        String actual = solution.solution(food);

        //then
        assertThat(actual).isEqualTo("1223330333221");
    }

}
