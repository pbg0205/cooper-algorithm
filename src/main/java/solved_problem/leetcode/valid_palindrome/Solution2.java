package solved_problem.leetcode.valid_palindrome;

class Solution2 {
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		char[] chars = s.toCharArray();
		while (start < end) {
			if (!Character.isLetterOrDigit(chars[start])) {
				start++;
				continue;
			}

			if (!Character.isLetterOrDigit(chars[end])) {
				end--;
				continue;
			}

			if (!(Character.toLowerCase(chars[start]) == Character.toLowerCase(chars[end]))) {
				return false;
			}

			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		boolean result = solution.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println("result = " + result);
	}

}
