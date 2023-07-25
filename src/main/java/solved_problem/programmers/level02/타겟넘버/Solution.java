package solved_problem.programmers.level02.타겟넘버;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int nowIndex, int currentSum) {
        if (nowIndex == numbers.length) {
            return (currentSum == target) ? 1 : 0;
        }

        return dfs(numbers, target, nowIndex + 1, currentSum + numbers[nowIndex]) +
                dfs(numbers, target, nowIndex + 1, currentSum - numbers[nowIndex]);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Solution solution = new Solution();
        int result = solution.solution(numbers, target);
        System.out.println("result = " + result);
    }

}

/**
 * 테스트 1 〉	통과 (5.57ms, 79.9MB)
 * 테스트 2 〉	통과 (9.21ms, 73.3MB)
 * 테스트 3 〉	통과 (0.20ms, 72MB)
 * 테스트 4 〉	통과 (0.37ms, 72.4MB)
 * 테스트 5 〉	통과 (0.89ms, 80.3MB)
 * 테스트 6 〉	통과 (0.36ms, 81.1MB)
 * 테스트 7 〉	통과 (0.18ms, 78.2MB)
 * 테스트 8 〉	통과 (0.38ms, 82.9MB)
 */
