package solved_problem.programmers.level02.카펫;

class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x;
        int y;

        for (int expected = 1; expected <= yellow; expected++) {
            if (yellow % expected != 0) {
                continue;
            }

            y = yellow / expected;
            x = yellow / y;

            boolean isBrownSize = (brown == (x + 2) * (y + 2) - yellow);

            if (!isBrownSize) {
                continue;
            }

            if (x >= y) {
                answer[0] = x + 2;
                answer[1] = y + 2;
            } else {
                answer[0] = y + 2;
                answer[1] = x + 2;
            }

        }

        return answer;
    }

}
