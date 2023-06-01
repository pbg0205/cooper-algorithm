package solved_problem.baekjoon.바닥_장식_1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int ySize = Integer.parseInt(tokenizer.nextToken());
        int xSize = Integer.parseInt(tokenizer.nextToken());

        boolean[][] visited = new boolean[ySize][xSize];
        
        char[][] floors = new char[ySize][];
        for (int y = 0; y < ySize; y++) {
            floors[y] = reader.readLine().toCharArray();
        }
        
        int floorCount = 0;
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (!visited[y][x]) {
                    checkFloor(visited, floors, y, x);
                    floorCount++;
                }
                
            }
        }

        System.out.println(floorCount);
    }

    private static void checkFloor(boolean[][] visited, char[][] floors, int nowY, int nowX) {
        if (floors[nowY][nowX] == '|') {
            checkVerticalFloor(visited, floors, nowY, nowX);
        } else {
            checkHorizontal(visited, floors, nowY, nowX);
        } 
    }

    private static void checkVerticalFloor(boolean[][] visited, char[][] floors, int nowY, int nowX) {
        for (int y = nowY; y < visited.length; y++) {
            if (!visited[y][nowX] && floors[y][nowX] == '|') {
                visited[y][nowX] = true;
            } else {
                return;
            } 
        }
    }

    private static void checkHorizontal(boolean[][] visited, char[][] floors, int nowY, int nowX) {
        for (int x = nowX; x < visited[0].length; x++) {
            if (!visited[nowY][x] && floors[nowY][x] == '-') {
                visited[nowY][x] = true;
            } else {
                return;
            }
        }
    }

}
