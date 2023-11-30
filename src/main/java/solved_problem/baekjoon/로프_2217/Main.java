package solved_problem.baekjoon.로프_2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(reader.readLine());

		List<Integer> ropes = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ropes.add(Integer.parseInt(reader.readLine()));
		}

		Collections.sort(ropes);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			max = Math.max(max, ropes.get(i) * (k - i));
		}

		System.out.println(max);
	}
}
