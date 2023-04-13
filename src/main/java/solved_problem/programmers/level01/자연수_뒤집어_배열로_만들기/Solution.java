package solved_problem.programmers.level01.자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> solution(long n) {
        String numberStr = Long.toString(n);
        String reverseNumberStr = new StringBuilder(numberStr).reverse().toString();

        List<Integer> reverseNumbers = new ArrayList<>();
        for (char numberChar : reverseNumberStr.toCharArray()) {
            reverseNumbers.add(numberChar - '0');
        }

        return reverseNumbers;
    }

    /**
     * stream 을 쓰면 시간이 조금 더 느리긴 하다.
     */
    public List<Integer> solution2(long n) {
        String numberStr = Long.toString(n);
        return new StringBuilder(numberStr).reverse().chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

}
