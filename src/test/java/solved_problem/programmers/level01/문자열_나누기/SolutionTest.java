package solved_problem.programmers.level01.문자열_나누기;

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
    void test(String s, int result) {
        assertThat(solution.solution(s)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments("banana", 3),
                arguments("abracadabra", 6),
                arguments("aaabbaccccabba", 3)
        );
    }

}
