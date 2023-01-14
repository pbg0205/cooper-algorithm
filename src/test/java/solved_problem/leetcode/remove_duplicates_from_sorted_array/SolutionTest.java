package solved_problem.leetcode.remove_duplicates_from_sorted_array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("sampleMethodSource")
    void test(int[] nums, int output) {
        assertThat(solution.removeDuplicates(nums)).isEqualTo(output);
    }

    static Stream<Arguments> sampleMethodSource() {
        return Stream.of(
                Arguments.arguments((Object) new int[]{1, 1, 2}, 2),
                Arguments.arguments((Object) new int[]{0,0,1,1,1,2,2,3,3,4}, 5)
        );
    }

}
