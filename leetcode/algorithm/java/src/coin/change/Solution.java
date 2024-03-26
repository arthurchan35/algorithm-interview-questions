package coin.change;

import java.util.HashMap;

class Solution {

	HashMap<Integer, Integer> leastCoinsForAmmount;

	private void countCoins(int[] coins, int currentCoinIndex, int ammout) {

		if (currentCoinIndex < 0) {
			return;
		}

		int currentCoin = coins[currentCoinIndex];

		int currentCoinCount = ammout / currentCoin;

		int modulo = ammout % currentCoin;

		if (modulo == 0) {
			Integer currentLeastCoinsCount = leastCoinsForAmmount.get(ammout);

			if (currentLeastCoinsCount == null || currentLeastCoinsCount > currentCoinCount) {
				leastCoinsForAmmount.put(ammout, currentCoinCount);
			}
		}

		while (currentCoinCount > -1) {
			countCoins(
				coins, currentCoinIndex - 1, ammout - currentCoinCount * currentCoin);

			Integer restCoinsCount = leastCoinsForAmmount.get(ammout - currentCoinCount * currentCoin);

			if (restCoinsCount != null) {
				Integer currentLeastCoinsCount = leastCoinsForAmmount.get(ammout);

				if (currentLeastCoinsCount == null || currentLeastCoinsCount > currentCoinCount + restCoinsCount) {
					leastCoinsForAmmount.put(ammout, currentCoinCount + restCoinsCount);
				}
			}

			currentCoinCount -= 1;
		}
	}

	public int coinChange(int[] coins, int amount) {

		leastCoinsForAmmount = new HashMap<>(amount);

		countCoins(coins, coins.length - 1, amount);

		Integer leastCoinsCount = leastCoinsForAmmount.get(amount);

		return leastCoinsCount == null ? -1 : leastCoinsCount;
	}
}