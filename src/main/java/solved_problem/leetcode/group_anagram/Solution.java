package solved_problem.leetcode.group_anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> results = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);

			String key = String.valueOf(chars);
			if (!results.containsKey(key)) {
				results.put(key, new ArrayList<>());
			}
			results.get(key).add(str);
		}

		return new ArrayList<>(results.values());
	}

}
