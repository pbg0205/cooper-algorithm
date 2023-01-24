package solved_problem.programmers.level01.가장_가까운_같은_글자;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private final Solution solution = new Solution();

    @MethodSource("sampleSource")
    @ParameterizedTest
    void test(String s, List<Integer> result) {
        assertThat(solution.solution(s)).isEqualTo(result);
    }


    public static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments("banana", List.of(-1, -1, -1, 2, 2, 2)),
                arguments("foobar", List.of(-1, -1, 1, -1, -1, -1))
        );
    }
}
