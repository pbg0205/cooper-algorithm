package solved_problem.codility.lessons.lesson03.perm_missing_elem;

class Solution {
	public int solution(int[] A) {
		int n = A.length + 1;
		long expectedSum = (long) n * (n + 1) / 2;
		long actualSum = 0;

		for (int num : A) {
			actualSum += num;
		}

		return (int) (expectedSum - actualSum);
	}
}
