package solved_problem.programmers.level02.큰_수_만들기;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution2 {

    public String solution(String number, int k) {
        Deque<Character> stack = new LinkedList<>();
        int removeCount = 0;

        for (char currentNumber : number.toCharArray()) {
            while (removeCount < k && !stack.isEmpty() && currentNumber > stack.peek()) {
                stack.pollLast();
                removeCount++;
            }
            stack.addLast(currentNumber);
        }


        while (removeCount++ < k) {
            stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}

/**
 *  테스트 1 〉	통과 (2.16ms, 75.4MB)
 *  테스트 2 〉	통과 (2.48ms, 87.1MB)
 *  테스트 3 〉	통과 (3.01ms, 76.9MB)
 *  테스트 4 〉	통과 (7.17ms, 75.1MB)
 *  테스트 5 〉	통과 (4.91ms, 74.3MB)
 *  테스트 6 〉	통과 (9.24ms, 77.4MB)
 *  테스트 7 〉	통과 (17.70ms, 75.4MB)
 *  테스트 8 〉	통과 (24.53ms, 88.7MB)
 *  테스트 9 〉	통과 (58.07ms, 101MB)
 *  테스트 10 〉	통과 (72.45ms, 108MB)
 *  테스트 11 〉	통과 (1.80ms, 72.3MB)
 *  테스트 12 〉	통과 (1.84ms, 76.1MB)
 */
