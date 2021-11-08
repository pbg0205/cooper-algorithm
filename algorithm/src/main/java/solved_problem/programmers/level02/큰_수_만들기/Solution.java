package solved_problem.programmers.level02.큰_수_만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int maxIdx = 0;

        for (int nowIdx = 0; nowIdx < number.length() - k; nowIdx++) {
            char max = '0';
            for (int idx = maxIdx; idx <= nowIdx + k; idx++) {
                if (max < number.charAt(nowIdx)) {
                    max = number.charAt(nowIdx);
                    maxIdx = idx + 1;
                }
            }
            sb.append(max);
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
