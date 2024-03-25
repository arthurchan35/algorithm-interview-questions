package coin.change;

import java.util.Arrays;

class Solution {

	private int countCoins(int[] coins, int currentCoinIndex, int ammout) {

		if (currentCoinIndex < 0) {
			return -1;
		}

		int currentCoin = coins[currentCoinIndex];

		int currentCoinCount = ammout / currentCoin;

		int modulo = ammout % currentCoin;

		if (modulo == 0) {
			return currentCoinCount;
		}

		while (currentCoinCount > -1) {
			int restCoinsCount = countCoins(
				coins, currentCoinIndex - 1, ammout - currentCoinCount * currentCoin);

			if (restCoinsCount > 0) {
				return currentCoinCount + restCoinsCount;
			}

			currentCoinCount -= 1;
		}

		return -1;
	}

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		return countCoins(coins, coins.length - 1, amount);
	}
}