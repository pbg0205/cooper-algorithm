package solved_problem.programmers.level01.체육복;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution2 {

    public int solution(int n, int[] lost, int[] reserve) {
        /**
         * 정렬을 해야 하는 케이스 : 분실 2인 [3,1] / 여분 2인 [2,4]
         * - 2번이 3번에게 체육복을 빌려주면 4번은 1번에게 체육복을 빌려줄 수 없는 예외가 발생한다.
         */
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(owns);

        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        System.out.println(owns);

        Queue<Integer> queue = new LinkedList<>();
        for (int lostNumber : lost) {
            queue.add(lostNumber);
        }

        int count = 0;
        for (int reserveNumber : reserve) {
            if (owns.contains(reserveNumber)) {
                continue;
            }

            while (!queue.isEmpty() && (queue.peek() < reserveNumber - 1 || owns.contains(queue.peek()))) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                break;
            }

            if (queue.peek() <= reserveNumber + 1) {
                queue.poll();
                count++;
            }
        }

        return n - lost.length + owns.size() + count;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }

}
