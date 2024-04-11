package solved_problem.leetcode.binary_search;

class Solution2 {
	public int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	private int search(final int[] nums, final int target, final int left, final int right) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[mid] > target) {
			return search(nums, target, left, mid - 1);
		}

		if (nums[mid] < target) {
			return search(nums, target, mid + 1, right);
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int result = solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
		System.out.println("result = " + result);
	}

}
