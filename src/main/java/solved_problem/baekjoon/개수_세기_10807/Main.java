package solved_problem.baekjoon.개수_세기_10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> countMap = new HashMap<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		while (tokenizer.hasMoreTokens()) {
			int number = Integer.parseInt(tokenizer.nextToken());
			countMap.put(number, countMap.getOrDefault(number, 0) + 1);
		}

		int searchNumber = Integer.parseInt(reader.readLine());
		System.out.println(countMap.getOrDefault(searchNumber, 0));

		reader.close();
	}
}
