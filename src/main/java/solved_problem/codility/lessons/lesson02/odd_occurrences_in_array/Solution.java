package solved_problem.codility.lessons.lesson02.odd_occurrences_in_array;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int solution(int[] A) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int number : A) {
			numberMap.put(number, numberMap.getOrDefault(number, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> numberEntry : numberMap.entrySet()) {
			if (numberEntry.getValue() % 2 == 1) {
				return numberEntry.getKey();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new int[] {9, 3, 9, 3, 9, 7, 9});
		System.out.println("result = " + result);
	}

}
