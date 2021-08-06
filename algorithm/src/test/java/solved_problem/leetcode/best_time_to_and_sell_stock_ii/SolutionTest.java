package solved_problem.leetcode.best_time_to_and_sell_stock_ii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    @Test
    void maxProfitTest1() {
        //given
        int[] prices = {7, 1, 5, 3, 6, 4};

        //when
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);

        //then
        assertThat(maxProfit).isEqualTo(7);
    }
}
