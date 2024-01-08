package solved_problem.programmers.level01.가장_많이_받은_선물;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public int solution(String[] friends, String[] gifts) {
		Map<String, Integer> friendIndexMap = setFriendIndexMap(friends);
		int[][] giftSendCounts = new int[friends.length][friends.length];
		int[] giftIndexArray = new int[friends.length];

		for (String gift : gifts) {
			String[] split = gift.split(" ");
			int giverIndex = friendIndexMap.get(split[0]);
			int receiverIndex = friendIndexMap.get(split[1]);

			giftSendCounts[giverIndex][receiverIndex] += 1;
			giftIndexArray[giverIndex] += 1;
			giftIndexArray[receiverIndex] -= 1;
		}

		int[] result = new int[friends.length];
		for (int i = 0; i < friends.length; i++) {
			result[i] += countByGiftSendCount(giftSendCounts, i);
			List<Integer> giftIndexNeeded = getGiftNeededIndex(giftSendCounts, i);
			result[i] += countByGiftIndex(giftIndexArray, giftIndexNeeded, i);
		}

		return Arrays.stream(result).max().getAsInt();
	}

	private List<Integer> getGiftNeededIndex(int[][] giftSendCount, int targetIndex) {
		List<Integer> result = new ArrayList<>();
		for (int comparedIndex = 0; comparedIndex < giftSendCount.length; comparedIndex++) {
			if (giftSendCount[targetIndex][comparedIndex] == giftSendCount[comparedIndex][targetIndex]) {
				result.add(comparedIndex);
			}

		}
		return result;
	}

	private int countByGiftIndex(int[] giftIndexArray, List<Integer> giftNothingIndex, int targetIndex) {
		int count = 0;

		int targetGiftIndex = giftIndexArray[targetIndex];
		for (Integer nothingIndex : giftNothingIndex) {
			int compareIndex = giftIndexArray[nothingIndex];
			if (targetGiftIndex > compareIndex) {
				count++;
			}
		}

		return count;
	}

	private int countByGiftSendCount(int[][] giftCounts, int targetIndex) {
		int count = 0;
		for (int comparedIndex = 0; comparedIndex < giftCounts.length; comparedIndex++) {
			int targetGiftCount = giftCounts[targetIndex][comparedIndex];
			int comparedGiftCount = giftCounts[comparedIndex][targetIndex];

			if ((targetIndex == comparedIndex)) {
				continue;
			}

			if (targetGiftCount == 0 && comparedGiftCount == 0) {
				continue;
			}

			count += (targetGiftCount > comparedGiftCount) ? 1 : 0;
		}

		return count;
	}

	private Map<String, Integer> setFriendIndexMap(String[] friends) {
		Map<String, Integer> freindMap = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			freindMap.put(friends[i], i);
		}

		return freindMap;
	}

	// 조건 1 : 상대방에게 선물을 더 많이 주어야 함
	// 조건 2 : 선물지수가 높은 사람
	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.solution(
			new String[] {"a", "b", "c"},
			new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}
		);

		System.out.println("result = " + result);
	}

}
