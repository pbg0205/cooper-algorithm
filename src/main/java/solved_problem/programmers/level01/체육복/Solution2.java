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

        Set<Integer> lostSet = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(lostSet);

        lostSet.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        System.out.println(lostSet);

        Queue<Integer> lostNumberQueue = new LinkedList<>();
        for (int lostNumber : lost) {
            lostNumberQueue.add(lostNumber);
        }

        int count = 0;
        for (int reserveNumber : reserve) {
            if (lostSet.contains(reserveNumber)) {
                continue;
            }

            Integer lostNumber = lostNumberQueue.peek();
            while (!lostNumberQueue.isEmpty() && (borrowDisable(reserveNumber, lostNumber) || lostSet.contains(lostNumber))) {
                lostNumberQueue.poll();
            }

            if (lostNumberQueue.isEmpty()) {
                break;
            }

            if (borrowEnabled(reserveNumber, lostNumber)) {
                lostNumberQueue.poll();
                count++;
            }
        }

        return n - lost.length + lostSet.size() + count;
    }

    private static boolean borrowEnabled(int reserveNumber, Integer lostNumber) {
        return lostNumber <= reserveNumber + 1;
    }

    private boolean borrowDisable(int reserveNumber, Integer lostNumber) {
        return lostNumber < reserveNumber - 1;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
    }

}
