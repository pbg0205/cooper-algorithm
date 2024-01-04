package solved_problem.baekjoon.n번째_큰_수_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

		for (int i = 0; i < n; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			while (tokenizer.hasMoreTokens()) {
				int num = Integer.parseInt(tokenizer.nextToken());
				treeSet.add(num);

				if (treeSet.size() > n) {
					treeSet.pollLast();
				}
			}
		}
		System.out.println(treeSet.pollLast());
	}
}
