package solved_problem.programmers.level02.큰_수_만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int maxIdx = 0;
        char maxNumber;

        for (int currentIdx = 0; currentIdx < number.length() - k; currentIdx++) {
            maxNumber = '0';
            for (int searchIdx = maxIdx; searchIdx <= currentIdx + k; searchIdx++) {
                char searchNumber = number.charAt(searchIdx);
                if (maxNumber < searchNumber) {
                    maxNumber = searchNumber;
                    maxIdx = searchIdx + 1;
                }
            }
            sb.append(maxNumber);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        Solution solution = new Solution();
        String max = solution.solution(number, k);
        System.out.println("max = " + max);
    }

}

/**
 *   테스트 1 〉	통과 (0.04ms, 76.6MB)
 *   테스트 2 〉	통과 (0.04ms, 74.8MB)
 *   테스트 3 〉	통과 (0.04ms, 71.9MB)
 *   테스트 4 〉	통과 (0.12ms, 75.1MB)
 *   테스트 5 〉	통과 (0.38ms, 77.3MB)
 *   테스트 6 〉	통과 (20.94ms, 97.7MB)
 *   테스트 7 〉	통과 (36.89ms, 78.3MB)
 *   테스트 8 〉	통과 (230.38ms, 80.1MB)
 *   테스트 9 〉	통과 (14.12ms, 87.1MB)
 *   테스트 10 〉	통과 (7880.49ms, 86.5MB)
 *   테스트 11 〉	통과 (0.02ms, 72.8MB)
 *   테스트 12 〉	통과 (0.04ms, 76.4MB)
 */
