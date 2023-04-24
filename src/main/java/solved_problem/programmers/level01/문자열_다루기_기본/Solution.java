package solved_problem.programmers.level01.문자열_다루기_기본;

class Solution {

	public boolean solution(String s) {
		if (!(s.length() == 4 || s.length() == 6)) {
			return false;
		}

		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	// 정규식에서는 띄어쓰기 고려해야 함
	public boolean solution2(String s) {
		return s.matches("[0-9]{4}|[0-9]{6}");
	}

}
