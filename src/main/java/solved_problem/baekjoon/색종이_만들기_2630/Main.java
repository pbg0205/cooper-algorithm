package solved_problem.baekjoon.색종이_만들기_2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(reader.readLine());

        int[][] map = new int[n][n];
        for (int y = 0; y < n; y++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Count count = count(0, 0, n, map);
        System.out.println(count.whiteCount);
        System.out.println(count.blueCount);

        reader.close();
    }

    private static Count count(int offsetX, int offsetY, int n, int[][] map) {
        int h = n / 2;

        for (int y = offsetY; y < offsetY + n; y++) {
            for (int x = offsetX; x < offsetX + n; x++) {
                if (map[y][x] != map[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, map)
                            .add(count(offsetX + h, offsetY, h, map))
                            .add(count(offsetX, offsetY + h, h, map))
                            .add(count(offsetX + h, offsetY + h, h, map));
                }
            }
        }

        if (map[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }

    private static class Count {

        private final int whiteCount;
        private final int blueCount;

        public Count(int whiteCount, int blueCount) {
            this.whiteCount = whiteCount;
            this.blueCount = blueCount;
        }

        public Count add(Count other) {
            return new Count(this.whiteCount + other.whiteCount, this.blueCount + other.blueCount);
        }

    }

}
