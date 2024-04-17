package solved_problem.programmers.level01.개인정보_수집_유효기간;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<String, Integer> termMap = new HashMap<>();
		for (String term : terms) {
			String[] split = term.split(" ");
			String agreementType = split[0];
			int period = Integer.parseInt(split[1]);
			termMap.put(agreementType, period);
		}

		List<Integer> answer = new ArrayList<>();
		LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
		for (int i = 0; i < privacies.length; i++) {
			String[] split = privacies[i].split(" ");
			LocalDate agreementDate = LocalDate.parse(split[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
			String agreementType = split[1];
			Integer monthTerm = termMap.get(agreementType);

			LocalDate limitDate = agreementDate.plusMonths(monthTerm).minusDays(1);
			if (limitDate.getDayOfMonth() > 28) {
				limitDate = LocalDate.of(limitDate.getYear(), limitDate.getMonth(), 28);
			}

			if (todayDate.isAfter(limitDate)) {
				int number = i + 1;
				answer.add(number);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(
			"2010.01.01",
			new String[] {"Z 12"},
			new String[] {"2009.12.01 Z", "2001.01.01 Z"});

		System.out.println(Arrays.toString(result));
	}

}
