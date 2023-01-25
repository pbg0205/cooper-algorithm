package solved_problem.programmers.level02.시소_짝꿍;

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
    void test(int[] weights, int result) {
        assertThat(solution.solution(weights)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(new int[]{100,180,360,100,270}, 4)
        );
    }

}
