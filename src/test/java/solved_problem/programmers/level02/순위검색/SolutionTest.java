package solved_problem.programmers.level02.순위검색;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        //given
        String[] info = new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        //when
        int[] actual = solution.solution(info, query);

        //then
        assertThat(actual).isEqualTo(new int[]{1, 1, 1, 1, 2, 4});
    }

}
