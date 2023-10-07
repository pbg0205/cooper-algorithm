package solved_problem.codility.lessons.lesson01.binary_gap;

class Solution {

	public int solution(int N) {
		int max = 0;
		String binaryNumber = Integer.toString(N, 2);

		boolean search = false;
		int searchIdx = 0;
		for (int idx = 0; idx < binaryNumber.length(); idx++) {
			char[] binaries = binaryNumber.toCharArray();
			if (binaries[idx] == '1') {
				if (search) {
					max = Math.max(max, idx - searchIdx - 1);
					searchIdx = idx;
				}

				search = true;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(15);
		System.out.println("result = " + result);
	}

}
