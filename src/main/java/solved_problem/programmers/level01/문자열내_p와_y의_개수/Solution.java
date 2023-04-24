package solved_problem.programmers.level01.문자열내_p와_y의_개수;

class Solution {

	boolean solution(String s) {
		s = s.toLowerCase();

		int pRemovedLength = s.replace("p", "").length();
		int yRemovedLength = s.replace("y", "").length();

		int pCount = s.length() - pRemovedLength;
		int yCount = s.length() - yRemovedLength;

		return pCount == yCount;
	}

}
