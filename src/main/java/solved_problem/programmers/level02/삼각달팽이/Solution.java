package solved_problem.programmers.level02.삼각달팽이;

class Solution {

    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] snailMap = new int[n][n];

        int yPos = -1;
        int xPos = 0;
        int number = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < (n - y); x++) {
                if (y % 3 == 0) {
                    yPos++;
                }

                if (y % 3 == 1) {
                    xPos++;
                }

                if (y % 3 == 2) {
                    xPos--;
                    yPos--;
                }

                snailMap[yPos][xPos] = number++;
            }
        }

        int index = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x <= y; x++) {
                answer[index++] = snailMap[y][x];
            }
        }

        return answer;
    }

}
