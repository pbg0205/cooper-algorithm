package solved_problem.programmers.level02.택배_배달과_수거하기;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private Solution solution = new Solution();

    @MethodSource("sampleSource")
    @ParameterizedTest
    void test(int cap, int n, int[] deliveries, int[] pickups, int result) {
        assertThat(solution.solution(cap, n, deliveries, pickups)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(4,5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}, 16),
                arguments(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}, 30)
        );
    }

}
