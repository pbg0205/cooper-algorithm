package solved_problem.baekjoon.보물_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int N = Integer.parseInt(reader.readLine());

		List<Integer> aNumbers = new ArrayList<>();
		List<Integer> bNumbers = new ArrayList<>();

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			aNumbers.add(Integer.parseInt(tokenizer.nextToken()));
		}

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			bNumbers.add(Integer.parseInt(tokenizer.nextToken()));
		}

		aNumbers.sort(Comparator.naturalOrder());
		bNumbers.sort(Comparator.reverseOrder());

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += aNumbers.get(i) * bNumbers.get(i);
		}

		System.out.println(sum);
	}

}
