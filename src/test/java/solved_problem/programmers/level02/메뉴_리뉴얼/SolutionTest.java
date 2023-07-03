package solved_problem.programmers.level02.메뉴_리뉴얼;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(
                        new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                        new int[]{2, 3, 4},
                        List.of("AC", "ACDE", "BCFG", "CDE")
                )
                , Arguments.of(
                        new String[]{"ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE"},
                        new int[]{2, 3, 5},
                        List.of("AB", "ABC", "ABCDE", "ABD", "ABE", "AC", "ACD", "ACE", "AD", "ADE", "AE", "BC", "BCD", "BCE", "BD", "BDE", "BE", "CD", "CDE", "CE", "DE"))
        );
    }

    @MethodSource("testSource")
    @ParameterizedTest
    void test(String[] orders, int[] course, List<String> result) {
        //given, when
        List<String> actual = solution.solution(orders, course);

        //then
        assertThat(actual).isEqualTo(result);
    }

}
