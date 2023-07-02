package solved_problem.programmers.level01.두_개_뽑아서_더하기;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> solution(int[] numbers) {
        Set<Integer> numSumSet = new HashSet<>();

        for (int left = 0; left < numbers.length - 1; left++) {
            for (int right = left + 1; right < numbers.length; right++) {
                numSumSet.add(numbers[left] + numbers[right]);
            }
        }

        return numSumSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
