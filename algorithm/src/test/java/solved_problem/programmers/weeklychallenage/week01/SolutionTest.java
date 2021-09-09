package solved_problem.programmers.weeklychallenage.week01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void test01() {
        //given
        int price = 3;
        int money = 20;
        int count = 4;
        int expected = 10;

        //when
        long result = this.solution.solution(price, money, count);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
