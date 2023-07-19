package solved_problem.programmers.level03.등굣길;

class Solution2 {

    private static final int MODIFY_NUMBER = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int map[][] = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int y = 0; y < n; y++) {
            if (map[y][0] == -1) {
                break;
            }
            map[y][0] = 1;
        }

        for (int x = 0; x < m; x++) {
            if (map[0][x] == -1) {
                break;
            }
            map[0][x] = 1;
        }

        for (int y = 1; y < n; y++) {
            for (int x = 1; x < m; x++) {
                if (map[y][x] == -1) {
                    continue;
                }

                if (map[y - 1][x] != -1) {
                    map[y][x] += map[y - 1][x] % MODIFY_NUMBER;
                }

                if (map[y][x - 1] != -1) {
                    map[y][x] += map[y][x - 1] % MODIFY_NUMBER;
                }

            }
        }

        return map[n - 1][m - 1] % MODIFY_NUMBER;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.solution(4, 3, new int[][]{{2, 2}});
        System.out.println("result = " + result);
    }

}
