package solved_problem.programmers.level01.둘만의_암호;

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
    void test(String s, String skip, int index, String result) {
        assertThat(solution.solution(s, skip, index)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments("aukks", "wbqd", 5, "happy")
        );
    }


}
