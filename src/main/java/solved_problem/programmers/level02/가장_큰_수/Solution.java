package solved_problem.programmers.level02.가장_큰_수;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {

    public String solution(int[] numbers) {
        String[] numberStrArray = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numberStrArray, (a, b) -> (b + a).compareTo(a + b));

        if (numberStrArray[0].equals("0")) {
            return "0";
        }

        return Arrays.stream(numberStrArray).collect(Collectors.joining());
    }

}
