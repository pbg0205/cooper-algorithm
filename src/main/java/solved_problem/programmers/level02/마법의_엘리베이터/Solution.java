package solved_problem.programmers.level02.마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int underDigit = storey % 10;
            int upperDigit = (storey / 10) % 10;

            if (underDigit > 5) {
                answer += 10 - underDigit;
                storey += 10;
            } else if (underDigit == 5) {
                answer += 5;
                storey += (upperDigit >= 5) ? 10 : 0;
            } else {
                answer += underDigit;
            }

            storey /= 10;
        }

        return answer;
    }

}
