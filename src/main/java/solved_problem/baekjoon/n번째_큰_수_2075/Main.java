package solved_problem.baekjoon.n번째_큰_수_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		TreeSet treeSet = new TreeSet(Collections.reverseOrder());
		for (int row = 0; row < n; row++) {
			String line = reader.readLine();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens()) {
				int number = Integer.parseInt(tokenizer.nextToken());
				treeSet.add(number);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			treeSet.pollFirst();
		}

		System.out.println(treeSet.pollFirst());

		reader.close();
	}

}
