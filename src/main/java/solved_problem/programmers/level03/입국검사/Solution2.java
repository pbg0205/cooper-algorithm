package solved_problem.programmers.level03.입국검사;

import java.util.Arrays;

class Solution2 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 1;
        long max = (long) times[times.length - 1] * n;

        while (min <= max) {
            long sum = 0L; // 입국 검사한 사람 수
            long mid = min + (max - min) / 2; // 소요 시간

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        long result = solution2.solution(6, new int[]{7, 10});
        System.out.println("result = " + result);
    }
}
