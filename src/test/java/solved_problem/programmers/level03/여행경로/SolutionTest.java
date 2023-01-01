package solved_problem.programmers.level03.여행경로;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void solutionTest() {
        //given
        String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        //when
        String[] result = solution.solution(tickets);

        //then
        assertThat(result).isEqualTo(new String[]{"ICN", "JFK", "HND", "IAD"});
    }
}
