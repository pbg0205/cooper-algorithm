package solved_problem.programmers.level03.입국검사;

class Solution {

    public long solution(int n, int[] times) {
        long start = 0L;
        long end = 1_000_000_000_000_000_000L;

        while (start < end) {
            long totalTime = (start + end) / 2;
            if (isValid(totalTime, n, times)) {
                end = totalTime;
            } else {
                start = totalTime + 1;
            }
        }

        return start;
    }

    private boolean isValid(long totalTime, int waitCount, int[] times) {
        long successCount = 0L;

        for (int time : times) {
            successCount += totalTime / time;
        }

        return successCount >= waitCount;
    }

}
