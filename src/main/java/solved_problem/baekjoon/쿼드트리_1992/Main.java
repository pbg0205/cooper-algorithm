package solved_problem.baekjoon.쿼드트리_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] map = new int[n][n];
        for (int y = 0; y < n; y++) {
            String[] temp = reader.readLine().split("");
            for (int x = 0; x < temp.length; x++) {
                map[y][x] = Integer.parseInt(temp[x]);
            }
        }

        System.out.println(compress(0, 0, n, map));
    }

    private static StringBuilder compress(int offsetX, int offsetY, int size, int[][] map) {
        StringBuilder builder = new StringBuilder();

        int h = size / 2;
        for (int y = offsetY; y < offsetY + size; y++) {
            for (int x = offsetX; x < offsetX + size; x++) {
                if (map[offsetY][offsetX] != map[y][x]) {
                    return builder.append("(") // 루프에서 벗어날 때, 테두리에 값을 두르고 싶은 경우에는 이곳에
                            .append(compress(offsetX, offsetY, h, map))
                            .append(compress(offsetX + h, offsetY, h, map))
                            .append(compress(offsetX, offsetY + h, h, map))
                            .append(compress(offsetX + h, offsetY + h, h, map))
                            .append(")"); // 루프에서 벗어날 때, 테두리에 값을 두르고 싶은 경우에는 이곳에
                }
            }
        }

        if (map[offsetY][offsetX] == 1) {
            return builder.append("1");
        }
        return builder.append("0");
    }

}
