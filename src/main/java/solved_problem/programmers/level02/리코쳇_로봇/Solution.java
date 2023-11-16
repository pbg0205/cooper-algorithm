package solved_problem.programmers.level02.리코쳇_로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private final char ROBOT = 'R';
	private final char DISABLE = 'D';
	private final char GOAL = 'G';


	public int solution(String[] board) {
		Point robot = initPoint(board, ROBOT);
		Point goal = initPoint(board, GOAL);

		return bfs(board, robot, goal);
	}

	private int bfs(String[] board, Point robot, Point goal) {
		int rowSize = board.length;
		int colSize = board[0].length();
		boolean[][] visited = new boolean[rowSize][colSize];

		visited[robot.y][robot.x] = true;

		Queue<Point> queue = new LinkedList<>();
		queue.add(robot);

		while (!queue.isEmpty()) {
			Point poll = queue.poll();

			if ((poll.y == goal.y) && (poll.x == goal.x)) {
				return poll.depth;
			}

			for (int i = 0; i < direction.length; i++) {
				int ny = poll.y;
				int nx = poll.x;

				while (inRange(ny, nx, board) && board[ny].charAt(nx) != DISABLE) {
					ny += direction[i][0];
					nx += direction[i][1];
				}

				ny -= direction[i][0];
				nx -= direction[i][1];

				if (visited[ny][nx] || (poll.y == ny && poll.x == nx)) {
					continue;
				}

				visited[ny][nx] = true;
				queue.add(new Point(ny, nx, poll.depth + 1));
			}
		}

		return -1;
	}

	private boolean inRange(int y, int x, String[] board) {
		return ((0 <= y) && (y < board.length)) && ((0 <= x) && (x < board[0].length()));
	}

	private Point initPoint(String[] board, char target) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[0].length(); x++) {
				if (board[y].charAt(x) == target) {
					return new Point(y, x, 0);
				}
			}
		}

		return new Point(-1, -1, 0);
	}

	private static class Point {
		private int y;
		private int x;
		private int depth;

		public Point(int y, int x, int depth) {
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
		System.out.println("result = " + result);
	}
}
