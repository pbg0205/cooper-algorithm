package solved_problem.programmers.level01.모의고사;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> solution(int[] answers) {
		int[] answer = {};

		int[] supoja1 = {1, 2, 3, 4, 5};
		int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] correct_num = new int[4];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == supoja1[i % supoja1.length]) {
				correct_num[1]++;
			}
			if (answers[i] == supoja2[i % supoja2.length]) {
				correct_num[2]++;
			}
			if (answers[i] == supoja3[i % supoja3.length]) {
				correct_num[3]++;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int correct : correct_num) {
			max = Math.max(max, correct);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < correct_num.length; i++) {
			if(correct_num[i] == max){
				list.add(i);
			}
		}

		return list;
	}

}
