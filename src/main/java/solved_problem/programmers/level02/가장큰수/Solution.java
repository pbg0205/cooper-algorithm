package solved_problem.programmers.level02.가장큰수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] temp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));

        if (temp[0].equals("0")) {
            answer.append("0");
            return answer.toString();
        }

        for (String s : temp) {
            answer.append(s);
        }

        return answer.toString();
    }
}
