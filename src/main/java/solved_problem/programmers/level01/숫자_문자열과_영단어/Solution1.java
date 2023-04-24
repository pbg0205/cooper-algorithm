package solved_problem.programmers.level01.숫자_문자열과_영단어;

public class Solution1 {
	public int solution(String s) {
		StringBuilder answer = new StringBuilder();

		int index = 0;
		while (index < s.length()) {
			StringBuilder numberAsString = new StringBuilder();

			if (isNumeric(s.charAt(index))) {
				answer.append(s.charAt(index));
				index++;
				continue;
			}

			while (index < s.length() && !isNumeric(s.charAt(index))) {
				numberAsString.append(s.charAt(index));

				if (isNumberFormat(numberAsString.toString())) {
					answer.append(convertToNumber(numberAsString.toString()));
					index++;
					break;
				}
				index++;
			}

		}

		return Integer.parseInt(answer.toString());
	}

	private int convertToNumber(String numberAsString) {
		switch (numberAsString) {
			case "zero":
				return 0;
			case "one":
				return 1;
			case "two":
				return 2;
			case "three":
				return 3;
			case "four":
				return 4;
			case "five":
				return 5;
			case "six":
				return 6;
			case "seven":
				return 7;
			case "eight":
				return 8;
			case "nine":
				return 9;
			default:
				return -1;
		}
	}

	private boolean isNumberFormat(String numberAsString) {
		return numberAsString.equals("zero") || numberAsString.equals("one") || numberAsString.equals("two") ||
		  numberAsString.equals("three") || numberAsString.equals("four") || numberAsString.equals("five") ||
		  numberAsString.equals("six") || numberAsString.equals("seven") || numberAsString.equals("eight") ||
		  numberAsString.equals("nine");
	}

	private boolean isNumeric(char c) {
		return '0' <= c && c <= '9';
	}

}
