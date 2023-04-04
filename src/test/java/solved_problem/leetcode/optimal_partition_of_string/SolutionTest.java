package solved_problem.leetcode.optimal_partition_of_string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        assertAll(
                () -> assertThat(solution.partitionString("abacaba")).isEqualTo(4),
                () -> assertThat(solution.partitionString("ssssss")).isEqualTo(6)
        );
    }

}
