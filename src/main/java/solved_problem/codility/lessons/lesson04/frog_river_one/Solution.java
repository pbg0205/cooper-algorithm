package solved_problem.codility.lessons.lesson04.frog_river_one;

class Solution {
	public int solution(int X, int[] A) {
		boolean[] leaves = new boolean[X + 1];
		int positionCount = X;

		for (int i = 0; i < A.length; i++) {
			int fallingPosition = A[i];
			if (!leaves[fallingPosition]) {
				leaves[fallingPosition] = true;
				positionCount--;
			}

			if (positionCount == 0) {
				return i;
			}
		}

		return -1;
	}
}
