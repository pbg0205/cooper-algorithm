package solved_problem.programmers.level02.가장_큰_수;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution2 {

    // 정규식을 통해 부수적인 0 을 제거하는 코드
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }

}
