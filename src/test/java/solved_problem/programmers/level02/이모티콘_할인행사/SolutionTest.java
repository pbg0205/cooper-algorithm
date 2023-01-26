package solved_problem.programmers.level02.이모티콘_할인행사;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private Solution solution = new Solution();

    @MethodSource("sampleSource")
    @ParameterizedTest
    void test(int[][] users, int[] emoticons, List<Integer> result) {
        assertThat(solution.solution(users, emoticons)).isEqualTo(result);
    }

    static Stream<Arguments> sampleSource() {
        return Stream.of(
                arguments(new int[][] {{40, 10000}, {25, 10000}}, new int[]{7000, 9000}, List.of(1, 5400)),
                arguments(
                        new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                        new int[]{1300, 1500, 1600, 4900},
                        List.of(4, 13860)
                )
        );
    }

}
