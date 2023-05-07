package solved_problem.programmers.level01.덧칠하기;

public class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int index = 0;
        while (index < section.length) {
            int maxFillIndex = section[index] + m - 1;
            int nowIndex = index;

            while (nowIndex < section.length && section[nowIndex] <= maxFillIndex) {
                nowIndex++;
            }

            answer++;
            index = nowIndex;
        }

        return answer;
    }

}
