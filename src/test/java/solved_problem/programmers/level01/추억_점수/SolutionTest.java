package solved_problem.programmers.level01.추억_점수;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        //when
        int[] actual = solution.solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}}
        );

        //then
        assertThat(actual).isEqualTo(new int[]{19, 15, 6});
    }

}
