package solved_problem.leetcode.most_common_word;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> ban = new HashSet<>();
		for (String word : banned) {
			ban.add(word.toLowerCase());
		}

		Map<String, Integer> counts = new HashMap<>();
		String[] words = paragraph.replaceAll("\\W+", " ").split(" ");
		for (String word : words) {
			String lowerCase = word.toLowerCase();
			if (!ban.contains(lowerCase)) {
				counts.put(lowerCase, counts.getOrDefault(lowerCase, 0) + 1);
			}
		}

		System.out.println("counts = " + counts);

		// int max = Integer.MIN_VALUE;
		// String word = "";
		// for (Map.Entry<String, Integer> entry : counts.entrySet()) {
		// 	if (max < entry.getValue()) {
		// 		max = entry.getValue();
		// 		word = entry.getKey();
		// 	}
		// }
		//
		// return word;

		return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
		System.out.println("result = " + result);
	}

}
