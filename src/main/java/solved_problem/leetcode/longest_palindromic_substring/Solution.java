package solved_problem.leetcode.longest_palindromic_substring;

class Solution {

	int start = 0;
	int maxLen = 0;

	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}

		for (int idx = 0; idx < s.length() - 1; idx++) {
			extendPalindrome(s, idx, idx + 1);
			extendPalindrome(s, idx, idx + 2);
		}

		return s.substring(start, start + maxLen);
	}

	private void extendPalindrome(final String s, int left, int right) {
		while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
			left--;
			right++;
		}

		int palindromeLen = right - left - 1;
		if (maxLen < palindromeLen) {
			start = left + 1;
			maxLen = palindromeLen;

			System.out.println("start = " + start);
			System.out.println("maxLen = " + maxLen);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.longestPalindrome("cbbd");
		System.out.println("result = " + result);
	}

}
