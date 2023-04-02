package solved_problem.leetcode.successful_pairs_of_spells_and_potions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private Solution solution = new Solution();

    @MethodSource("sampleSource")
    @ParameterizedTest
    void test(int[] spell, int[] position, long success, int[] result) {
        assertThat(solution.successfulPairs(spell, position, success)).isEqualTo(result);
    }

    public static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7, new int[]{4, 0, 3}),
                arguments(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16, new int[]{2, 0, 2})
        );

    }

}
