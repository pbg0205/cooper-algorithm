package solved_problem.baekjoon.유기농_배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {1, 0,-1, 0};
    private static int[] dy = {0,-1, 0, 1};

    private static int rowSize;
    private static int colSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());
            int numberOfCabbage = Integer.parseInt(st.nextToken());
            int wormCount = 0;

            map = new int[rowSize][colSize];
            visited = new boolean[rowSize][colSize];

            for (int i = 0; i < numberOfCabbage; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                map[row][col] = 1;
            }

            for(int row = 0; row < rowSize; row++){
                for(int col = 0; col < colSize; col++){
                    if(!visited[row][col] && map[row][col] == 1){
                        bfs(row, col);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);

        }
    }

    private static void bfs(int row, int col) {
        Queue<Location> queue = new LinkedList<>();

        queue.offer(new Location(row, col));

        while(!queue.isEmpty()){
            Location now = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = now.x + dx[idx];
                int ny = now.y + dy[idx];

                if(isBoundary(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.offer(new Location(nx, ny));
                }
            }
        }
    }

    private static boolean isBoundary(int x, int y) {
        return (0 <= x && x < rowSize) && (0 <= y && y < colSize);
    }
}

class Location{
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
