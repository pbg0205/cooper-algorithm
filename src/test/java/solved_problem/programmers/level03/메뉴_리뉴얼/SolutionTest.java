package solved_problem.programmers.level03.메뉴_리뉴얼;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        //given
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = new int[]{2, 3, 4};

        //when
        String[] actual = solution.solution(orders, courses);

        assertThat(actual).isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});
    }

}
