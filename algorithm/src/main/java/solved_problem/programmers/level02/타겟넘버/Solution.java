package solved_problem.programmers.level02.타겟넘버;

class Solution {
    public int solution(int[] numbers, int target) {
        int count = CountUtil.count(numbers, target);
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Solution solution = new Solution();
        int result = solution.solution(numbers, target);
        System.out.println(result);
    }
}

class CountUtil {

    public static int count(int[] numbers, int target) {
        int sum = 0;
        int index = 0;
        return calculateCount(numbers, target, sum, index);
    }

    private static int calculateCount(int[] numbers, int target, int sum, int index) {
        int numberLength = numbers.length;
        if (index == numberLength) {
            return isTarget(target, sum) ? 1 : 0;
        }

        int nextNumber = numbers[index];
        int addCount = calculateCount(numbers, target, sum + nextNumber, index + 1);
        int substractCount = calculateCount(numbers, target, sum - nextNumber, index + 1);

        return addCount + substractCount;
    }

    private static boolean isTarget(int target, int sum) {
        return target == sum;
    }
}
