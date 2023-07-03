package solved_problem.programmers.level02.메뉴_리뉴얼;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    private Solution2 solution2 = new Solution2();

    @Test
    void test() {
        //given
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = new int[]{2, 3, 4};

        //when
        String[] actual = solution2.solution(orders, courses);

        assertThat(actual).isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});
    }

}
