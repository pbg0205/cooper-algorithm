package solved_problem.leetcode.kth_largest_element_in_an_array;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		for (int num : nums) {
			priorityQueue.add(num);
		}

		for (int i = 1; i < k; i++) {
			priorityQueue.poll();
		}

		return priorityQueue.poll();
	}
}
