package solved_problem.leetcode.course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {

	// 순환 여부를 dfs 로 해결하는 문제 => 순환하지 않아야 한다.
	// 방문했던 node 를 중복해서 방문하므로 Time Limit Exceeded 발생
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> finishToTakesMap = new HashMap<>();
		for (int[] prerequisite : prerequisites) {
			int finish = prerequisite[0];
			int need = prerequisite[1];

			finishToTakesMap.putIfAbsent(finish, new ArrayList<>());
			finishToTakesMap.get(finish).add(need);
		}

		List<Integer> takes = new ArrayList<>();
		List<Integer> visit = new ArrayList<>();
		for (Integer finish : finishToTakesMap.keySet()) {
			if (hasCycle(finishToTakesMap, finish, takes, visit)) {
				return false;
			}
		}

		return true;
	}

	private boolean hasCycle(final Map<Integer, List<Integer>> finishToTakesMap, final Integer finish,
		final List<Integer> takes, final List<Integer> visit) {

		if (takes.contains(finish)) {
			return true; // 단방향 사이클이 존재하기 때문에 true
		}

		if (visit.contains(finish)) {
			return false; // 이전에 방문했던 로직이므로 사이클 존재X
		}

		if (finishToTakesMap.containsKey(finish)) {
			takes.add(finish);
			for (Integer need : finishToTakesMap.get(finish)) {
				if (hasCycle(finishToTakesMap, need, takes, visit)) {
					return true;
				}
			}
			takes.remove(finish);
			visit.add(finish); // 방문한 노ㄷ로 추가
		}

		return false;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		// boolean result = solution.canFinish(2, new int[][] {{1, 0}, {0, 1}});
		boolean result = solution.canFinish(2, new int[][] {{1, 0}});
		System.out.println("result = " + result);
	}

}
