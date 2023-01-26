package solved_problem.programmers.level02.두_큐_합_같게_만들기;

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
    void test(int[] queue1, int[] queue2, int result) {
        assertThat(solution.solution(queue1, queue2)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}, 2),
                arguments(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}, 7),
                arguments(new int[]{1, 1}, new int[]{1, 5}, -1)
        );
    }

}
