package solved_problem.programmers.level01.모의고사;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void test() {
		//given
		int[] answers = new int[] {1, 2, 3, 4, 5};

		//when
		List<Integer> winner = solution.solution(answers);

		//then
		assertThat(winner).contains(1);
	}

}
