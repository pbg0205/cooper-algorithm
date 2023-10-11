package solved_problem.codility.lessons.lesson07.fish;

import java.util.Stack;

class Solution {
	public int solution(int[] A, int[] B) { // A : 물고기 무게, B : 물고기 이동 방향(0 : upstream, 1 : downstream)
		Stack<Integer> downstreamFish = new Stack<>();

		int aliveCount = 0;
		for (int i = 0; i < A.length; i++) {
			int upstreamFishSize = A[i];

			if (isDownstream(B[i])) {
				downstreamFish.push(upstreamFishSize);
				continue;
			}

			while (!downstreamFish.isEmpty()) {
				int downstreamFishSize = downstreamFish.peek();
				if (upstreamFishSize > downstreamFishSize) {
					downstreamFish.pop();
				} else {
					break;
				}
			}

			if (downstreamFish.isEmpty()) {
				aliveCount++;
			}
		}

		aliveCount += downstreamFish.size();
		return aliveCount;
	}

	private boolean isDownstream(int direction) {
		return direction == 1;
	}
}
