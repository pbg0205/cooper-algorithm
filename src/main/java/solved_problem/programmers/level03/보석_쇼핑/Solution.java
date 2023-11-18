package solved_problem.programmers.level03.보석_쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] gems) {
		int start = 0;
		int end = gems.length - 1;

		Set<String> gemSet = new HashSet<>(List.of(gems));

		int s = 0;
		int e = s;
		Map<String, Integer> contains = new HashMap<>();
		contains.put(gems[s], 1);

		while (s < gems.length) {
			if (contains.keySet().size() == gemSet.size()) {
				if (e - s < end - start) {
					start = s;
					end = e;
				}

				contains.put(gems[s], contains.get(gems[s]) - 1);
				if (contains.get(gems[s]) == 0) {
					contains.remove(gems[s]);
				}
				s++;
			} else if (e < gems.length - 1) {
				e++;
				contains.put(gems[e], contains.getOrDefault(gems[e], 0) + 1);
			} else {
				break;
			}
		}

		return new int[] {start + 1, end + 1};
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(new String[] {"AA", "AB", "AC", "AA", "AC"});
		for (int i : result) {
			System.out.println(i);
		}
	}
}
