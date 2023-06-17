package solved_problem.programmers.level02.삼각달팽이;

class Solution2 {

    private int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, -1}};

    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] snailMap = new int[n][n];

        int yPos = -1;
        int xPos = 0;
        int number = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < (n - y); x++) {
                int index = y % 3;
                yPos += direction[index][0];
                xPos += direction[index][1];

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

/**
 * direction 배열을 사용하면 코드를 더욱 간결화할 수 있다0.
 */
