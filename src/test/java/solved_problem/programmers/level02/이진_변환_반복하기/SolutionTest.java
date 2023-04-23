package solved_problem.programmers.level02.이진_변환_반복하기;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("testSource")
    void test(String tc, int[] expected) {
        //given, when
        int[] actual = solution.solution(tc);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.arguments("110010101001", new int[]{3, 8}),
                Arguments.arguments("01110", new int[]{3, 3}),
                Arguments.arguments("1111111", new int[]{4, 1})
        );
    }

}
