package solved_problem.leetcode.boats_to_save_people;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        assertAll(
                () -> assertThat(solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3)).isEqualTo(3),
                () -> assertThat(solution.numRescueBoats(new int[]{3, 5, 3, 4}, 5)).isEqualTo(4)
        );
    }

}
