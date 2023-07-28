package solved_problem.programmers.level02.큰_수_만들기;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    private Solution2 solution = new Solution2();

    @ParameterizedTest
    @MethodSource("testcase")
    void test(String number, int k, String expected) {
        //given, when
        String result = solution.solution(number, k);

        //when
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("1924", "2", "94"),
                Arguments.of("1231234", "3", "3234"),
                Arguments.of("4321", "1", "432") // testcase 12: 앞의 숫자가 뒤의 숫자보다 모두 작은 경우
        );
    }
}
