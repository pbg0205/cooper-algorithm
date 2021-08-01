package leetcode.window_minimum_substring;

class Solution3 {
    public String minWindow(String s, String t) {
        int[] charArray = new int[128];

        for (char c : t.toCharArray()) {
            charArray[c]++;
        }

        int start = 0;
        int length = Integer.MAX_VALUE;
        int counter = t.length();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charArray[s.charAt(i)]-- > 0) {
                counter--;
            }

            while (counter == 0) {
                if (i - j + 1 < length) {
                    length = i - j + 1;
                    start = j;
                }

                if (++charArray[s.charAt(j++)] > 0) {
                    counter++;
                }

            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
