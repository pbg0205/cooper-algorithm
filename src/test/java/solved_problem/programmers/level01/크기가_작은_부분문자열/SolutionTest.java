package solved_problem.programmers.level01.크기가_작은_부분문자열;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private final Solution solution = new Solution();

    @MethodSource("sampleSource")
    @ParameterizedTest
    void test(String t, String p, int result) {
        assertThat(solution.solution(t, p)).isEqualTo(result);
    }

    public static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments("3141592", "271", 2),
                arguments("500220839878", "7", 8),
                arguments("10203", "15", 3)
        );
    }

}
