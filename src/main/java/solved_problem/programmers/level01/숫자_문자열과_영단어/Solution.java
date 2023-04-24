package solved_problem.programmers.level01.숫자_문자열과_영단어;

class Solution {

	private static final String[] NUMBER_WORDS = new String[] {
	  "one", "two", "three",
	  "four", "five", "six",
	  "seven", "eight", "nine",
	  "zero"
	};

	public int solution(String s) {
		for (int index = 0; index < s.length(); index++) {
			s = s.replace(NUMBER_WORDS[index], Integer.toString(index));
		}

		return Integer.parseInt(s);
	}

}
