package solved_problem.baekjoon.연구소_14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int rowSize;
	static int colSize;

	static int[][] map;
	static int[][] copiedMap;
	static int max = 0;

	static List<Location> virusList = new ArrayList<Location>();

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		copiedMap = new int[rowSize][colSize];

		for (int row = 0; row < rowSize; row++) {

			st = new StringTokenizer(br.readLine());

			for (int col = 0; col < colSize; col++) {

				map[row][col] = Integer.parseInt(st.nextToken());

				if (map[row][col] == 2)
					virusList.add(new Location(row, col));
			}
		}

		setWall(0, 0);

		System.out.println(max);

		br.close();
	}

	static void setWall(int start, int depth) {
		if (depth == 3) {

			copyMap();

			for (Location dot : virusList) {
				spreadVirus(dot.x, dot.y);
			}

			max = Math.max(max, getSafeArea());
			return;
		}

		for (int i = start; i < rowSize * colSize; i++) {
			int x = i / colSize;
			int y = i % colSize;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				setWall(i + 1, depth + 1);
				map[x][y] = 0;
			}
		}
	}

	static void copyMap() {
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				copiedMap[row][col] = map[row][col];
			}
		}
	}

	static void spreadVirus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isBoundary(nx, ny)) {
				if (copiedMap[nx][ny] == 0) {
					copiedMap[nx][ny] = 2;
					spreadVirus(nx, ny);
				}
			}
		}
	}

	private static boolean isBoundary(int x, int y) {
		return (0 <= x && x < rowSize && 0 <= y && y < colSize);
	}

	static int getSafeArea() {
		int safe = 0;

		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (copiedMap[row][col] == 0)
					safe++;
			}
		}
		return safe;
	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
