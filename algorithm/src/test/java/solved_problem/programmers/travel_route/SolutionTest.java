package solved_problem.programmers.travel_route;


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
