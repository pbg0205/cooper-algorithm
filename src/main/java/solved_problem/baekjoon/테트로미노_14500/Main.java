package solved_problem.baekjoon.테트로미노_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int height, width;
	static int ans = 0;

	static int map[][];
	static boolean visited[][];

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = makeStringTokenizer(br.readLine());

		height = toInt(st.nextToken());
		width = toInt(st.nextToken());

		map = new int[height][width];
		visited = new boolean[height][width];

		for (int row = 0; row <height; row++) {
			st = makeStringTokenizer(br.readLine());
			for (int col = 0; col < width; col++) {
				map[row][col] = toInt(st.nextToken());
			}
		}

		for (int row = 0; row <height; row++) {
			for (int col = 0; col < width; col++) {
				dfs(row, col, 0, 1);
				check(row, col);
			}
		}

		System.out.println(ans);

	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static StringTokenizer makeStringTokenizer(String str){
		return new StringTokenizer(str);
	}

	private static void dfs(int row, int col, int sum, int depth){
		if(depth > 4){
			ans = Math.max(ans, sum);
			return ;
		}

		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];

			if(isBoundary(nx, ny) && !visited[nx][ny]){
				dfs(nx, ny, sum + map[nx][ny], depth + 1);
			}
		}

		visited[row][col] = false;
	}

	private static void check(int row, int col) {

		int sum = map[row][col];
		int min = Integer.MAX_VALUE;
		int cnt = 1;

		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (isBoundary(nx, ny)) {
				sum += map[nx][ny];
				cnt += 1;
				min = Math.min(min, map[nx][ny]);
			}
		}
		if (cnt > 4)
			sum -= min;

		ans = Math.max(ans, sum);

	}

	private static boolean isBoundary(int row, int col){
		return (0 <= row && row < height) && (0 <= col && col < width);
	}
}
