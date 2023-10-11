package solved_problem.codility.lessons.lesson03.tape_equilibrium;

import java.util.Arrays;

class Solution {
	public int solution(int[] A) {
		int prevSum = 0;
		int afterSum = Arrays.stream(A).sum();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			prevSum += A[i];
			afterSum -= A[i];

			int subtract = Math.abs(prevSum -afterSum);
			min = Math.min(min, subtract);
		}

		return min;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {-1000, 1000});
		System.out.println("result = " + result);
	}
}
