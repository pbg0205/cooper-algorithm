package solved_problem.baekjoon.n과m2_15650;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		dfs(0, m, nums, list, results);

		for (List<Integer> result : results) {
			System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}

	private static void dfs(int start, int m, List<Integer> nums, List<Integer> list, List<List<Integer>> results) {
		if (list.size() == m) {
			results.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < nums.size(); i++) {
			list.add(nums.get(i));
			dfs(i + 1, m, nums, list, results);
			list.remove(list.size() - 1);
		}
	}

}
