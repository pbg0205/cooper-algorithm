package leetcode.largest_number;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] asString = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();

        if (asString[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < nums.length; i++) {
            sb.append(asString[i]);
        }

        return sb.toString();
    }
}
