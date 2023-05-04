package solved_problem.programmers.level01.카드뭉치;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("testcase")
    void test(String[] card1, String[] card2, String[] goal, String expected) {
        //when
        String actual = solution.solution(card1, card2, goal);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.arguments(
                        new String[]{"i", "drink", "water"},
                        new String[]{"want", "to"},
                        new String[]{"i", "want", "to", "drink", "water"},
                        "Yes"
                ),
                Arguments.arguments(
                        new String[]{"i", "water", "drink"},
                        new String[]{"want", "to"},
                        new String[]{"i", "want", "to", "drink", "water"},
                        "No"
                )
        );
    }

}
