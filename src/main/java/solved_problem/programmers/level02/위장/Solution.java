package solved_problem.programmers.level02.위장;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (a, b) -> a * (b + 1)).intValue() - 1;
    }
}
