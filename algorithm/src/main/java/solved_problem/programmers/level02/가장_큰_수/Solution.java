package solved_problem.programmers.level02.가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

        if (temp[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : temp) {
            sb.append(s);
        }

        return sb.toString();
    }
}
