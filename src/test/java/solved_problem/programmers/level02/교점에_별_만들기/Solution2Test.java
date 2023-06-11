package solved_problem.programmers.level02.교점에_별_만들기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    private Solution2 solution2 = new Solution2();

    @Test
    void test() {
        int[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };
        String[] actual = solution2.solution(line);
        assertThat(actual).isEqualTo(
                new String[]{
                        "....*....",
                        ".........",
                        ".........",
                        "*.......*",
                        ".........",
                        ".........",
                        ".........",
                        ".........",
                        "*.......*"
                });
    }

}
