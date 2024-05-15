package solved_problem.programmers.level02.요격시스템;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution(int[][] targets) {
		Arrays.sort(targets, Comparator.comparingInt(a -> a[0]));

		int answer = 0;
		int currentCoveragePoint = -1;

		for (int[] target : targets) {
			if (currentCoveragePoint <= target[0]) {
				answer++;
				currentCoveragePoint = target[1]; // 다음 요격 가능한 범위로 설정
			} else {
				currentCoveragePoint = Math.min(currentCoveragePoint, target[1]);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[][] {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
		System.out.println("result = " + result);
	}

}
