package solved_problem.codility.lessons.lesson03.forgjmp;

class Solution {
	public int solution(int X, int Y, int D) {
		return ((Y - X) % D == 0) ?
			(Y - X) / D :
			(Y - X) / D + 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(10, 85, 30);
		System.out.println("result = " + result);
	}
}
