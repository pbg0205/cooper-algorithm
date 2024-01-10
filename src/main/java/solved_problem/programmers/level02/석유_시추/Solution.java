package solved_problem.programmers.level02.석유_시추;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

	private int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public int solution(int[][] land) {
		int height = land.length;
		int width = land[0].length;

		int[][] chunkIds = new int[height][width];
		boolean[][] visit = new boolean[height][width];

		int chunkId = 0;
		Map<Integer, Integer> chunkAreaMap = new HashMap<>();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < land.length; y++) {
				if (land[y][x] == 1 && !visit[y][x]) { // not visit
					int area = getArea(land, visit, chunkIds, chunkId, new Point(y, x));
					chunkAreaMap.put(chunkId, area);
					chunkId++;
				}
			}
		}

		int answer = Integer.MIN_VALUE;
		for (int x = 0; x < width; x++) {
			int sum = 0;
			Set<Integer> chunkIdSet = new HashSet<>();

			for (int y = 0; y < height; y++) {
				if (land[y][x] == 1) {
					chunkIdSet.add(chunkIds[y][x]);
				}
			}

			for (int id : chunkIdSet) {
				sum += chunkAreaMap.get(id);
			}

			answer = Math.max(answer, sum);
		}

		return answer;
	}

	private int getArea(int[][] land, boolean[][] visit, int[][] chunkIds, int chunkId, Point point) {
		int result = 1;
		visit[point.y][point.x] = true;
		chunkIds[point.y][point.x] = chunkId;

		Queue<Point> queue = new LinkedList<>();
		queue.add(point);

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();

			for (int[] direction : directions) {
				Point nextPoint = new Point(currentPoint.y + direction[0], currentPoint.x + direction[1]);

				if (isBoundary(nextPoint, land.length, land[0].length) &&
					!visit[nextPoint.y][nextPoint.x] &&
					land[nextPoint.y][nextPoint.x] == 1
				) {
					queue.add(nextPoint);
					visit[nextPoint.y][nextPoint.x] = true;
					chunkIds[nextPoint.y][nextPoint.x] = chunkId;
					result++;
				}
			}
		}

		return result;
	}

	private boolean isBoundary(Point point, int ySize, int xSize) {
		return ((point.y >= 0) && (point.y < ySize)) && ((point.x >= 0) && (point.x < xSize));
	}

	private static class Point {
		private int y;
		private int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] land1 = new int[][] {
			{0, 0, 0, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0},
			{1, 1, 0, 0, 0, 1, 1, 0},
			{1, 1, 1, 0, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0, 1, 1}
		};

		int[][] land2 = new int[][] {
			{1, 0, 1, 0, 1, 1},
			{1, 0, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0},
			{1, 0, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1}
		};

		int[][] land3 = new int[][] {
			{1, 1, 1, 1},
			{1, 0, 0, 0},
			{1, 0, 1, 0},
			{1, 0, 0, 0},
			{1, 1, 1, 1}
		};

		int result = solution.solution(land1);
		System.out.println("result = " + result);
	}

}
