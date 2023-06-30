package solved_problem.programmers.level02.수식_최대화;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	void test() {
		//given
		String expression = "100-200*300-500+20";

		//when
		long actual = solution.solution(expression);

		//then
		int expected = 60420;
		assertThat(actual).isEqualTo(expected);
	}

}
