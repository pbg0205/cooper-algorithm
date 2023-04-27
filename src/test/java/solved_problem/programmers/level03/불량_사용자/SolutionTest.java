package solved_problem.programmers.level03.불량_사용자;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void test() {
		//given
		String[] user_id = new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = new String[] {"fr*d*", "abc1**"};

		//when
		solution.solution(user_id, banned_id);

		//then
	}
}
