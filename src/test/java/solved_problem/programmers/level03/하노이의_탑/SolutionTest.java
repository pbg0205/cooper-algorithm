package solved_problem.programmers.level03.하노이의_탑;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        //given
        int n = 2;

        //when
        List<int[]> actual = solution.solution(2);

        //then
        Assertions.assertThat(actual).isEqualTo(List.of(new int[]{1, 2}, new int[]{1, 3,}, new int[]{2, 3}));
    }

}
