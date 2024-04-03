package solved_problem.leetcode.best_time_to_buy_and_sell_stock;

class Solution {
	public int maxProfit(int[] prices) {
		int minPrice = prices[0];
		int maxLen = 0;

		for (int price : prices) {
			minPrice = Math.min(minPrice, price);

			if (price > minPrice + maxLen) {
				maxLen = price - minPrice;
			}
		}

		return maxLen;
	}

}
