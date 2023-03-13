package solved_problem.leetcode.reorder_data_in_log_files;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void test() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};

        assertThat(solution.reorderLogFiles(logs)).isEqualTo(output);
    }
}
