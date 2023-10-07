package solved_problem.codility.lessons.lesson02.cyclic_ratation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {

	public int[] solution(int[] A, int K) {
		LinkedList<Integer> numbers = new LinkedList<>();

		for (int i : A) {
			numbers.add(i);
		}

		if (A.length == 0) {
			K = 0;
		} else {
			int mod = K % A.length;
			K = (mod == 0) ? A.length : mod;
		}

		for (int i = 0; i < K; i++) {
			int pollNumber = numbers.pollLast();

			numbers.addFirst(pollNumber);
		}

		return numbers.stream().mapToInt(Integer::valueOf).toArray();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(new int[] {3, 8, 9, 7, 6}, 3);
		String collect = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(collect);

	}
}
