package solved_problem.programmers.level01.이상한_문자_만들기;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @MethodSource("testSource")
    @ParameterizedTest
    void test(String testcase, String expected) {
        //given, when
        String actual = solution.solution(testcase);

        //then
        assertThat(actual).isEqualTo(actual);
    }

    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of("try hello world", "TrY HeLlO WoRlD"),
                Arguments.of("aaa ", "AaA "),
                Arguments.of("  ", "  "),
                Arguments.of(" abc ", " AbC "),
                Arguments.of(" aBc   aBc   aBc ", " AbC   AbC   AbC "),
                Arguments.of("try hello wolrd   ", "TrY HeLlO WoLrD   ")
        );
    }
}
