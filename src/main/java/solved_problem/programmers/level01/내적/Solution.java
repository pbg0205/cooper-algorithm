package solved_problem.programmers.level01.내적;

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        int index = 0;
        while(index < a.length) {
            answer += a[index] * b[index];
            index++;
        }

        return answer;
    }
}
