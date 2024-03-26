package coin.change;

import java.util.HashMap;

class Solution {

	HashMap<Integer, Integer> leastCoinsForAmmount;

	private int countCoins(int[] coins, int ammout) {
		if (ammout < 0) {
			return -1;
		}

		Integer currentCoinsCount = leastCoinsForAmmount.get(ammout);
		if (currentCoinsCount != null) {
			return currentCoinsCount;
		}

		int minRestCoins = -1;

		for (int coin : coins) {
			int restCoins = countCoins(coins, ammout - coin);

			if (restCoins < 0) {
				continue;
			}

			if (minRestCoins == -1) {
				minRestCoins = restCoins;
			}
			else if (minRestCoins > restCoins) {
				minRestCoins = restCoins;
			}
		}

		int currentMinCoins = minRestCoins == -1 ? -1 : minRestCoins + 1;

		leastCoinsForAmmount.put(ammout, currentMinCoins);
		return currentMinCoins;
	}

	public int coinChange(int[] coins, int amount) {

		leastCoinsForAmmount = new HashMap<>(amount);

		leastCoinsForAmmount.put(0, 0);

		return countCoins(coins, amount);
	}
}