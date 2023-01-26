package solved_problem.programmers.level02.마법의_엘리베이터;

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
    void test(int storey, int result) {
        assertThat(solution.solution(storey)).isEqualTo(result);
    }


    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(16, 6),
                arguments(2554, 16)
        );
    }

}
