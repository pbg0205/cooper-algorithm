package solved_problem.baekjoon.Z_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int row;
    private static int col;

    private static final int[][] direction = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int size = (int) Math.pow(2, n);

        row = Integer.parseInt(tokenizer.nextToken());
        col = Integer.parseInt(tokenizer.nextToken());

        divide(0, 0, 0, size);

        reader.close();
    }

    private static void divide(int x, int y, int count, int size) {
        if (!isBoundary(x, y, size)) {
            return;
        }

        if (size == 2) {
            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                if (nx == row && ny == col) {
                    System.out.println(count + i);
                }
            }
            return;
        }

        int newSize = size / 2;

        divide(x, y, count, newSize);
        divide(x, y + newSize, count + (newSize * newSize), newSize);
        divide(x + newSize, y, count + (newSize * newSize * 2), newSize);
        divide(x + newSize, y + newSize, count + (newSize * newSize * 3), newSize);
    }

    private static boolean isBoundary(int x, int y, int size) {
        return (x > row - size && x <= row) && (y > col - size && y <= col);
    }
}
