package solved_problem.programmers.level01.없는_숫자_더하기;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> numberSet = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toSet());

        return IntStream.rangeClosed(0, 9)
                .filter(number -> !numberSet.contains(number))
                .sum();
    }

}
