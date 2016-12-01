package main.java.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Min coin change for a number
 * 
 * @author rahul2065
 *
 */
public class CoinChange {

	static int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	public static void minCoinsRequired(int [] coins ,int amount) {
		List<Integer> changes = new ArrayList<Integer>();
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount <= 0)
				break;
			while (amount >= coins[i]) {
				amount = amount - coins[i];
				changes.add(coins[i]);
			}
		}

		for (Integer change : changes) {
			System.out.println(change.intValue());
		}

	}

	public static int coinChange(int[] coins, int amount) {
		int coinsRequired = 0;
		Arrays.sort(coins);
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount / coins[i] > 0) {
				coinsRequired = coinsRequired + amount / coins[i];
				amount = amount - (amount / coins[i]) * coins[i];
			}
		}
		return (amount == 0) ? coinsRequired : -1;
	}

	public static void main(String[] args) {
		int coins[] = { 186,419,83,408};
		int amount = 6249;
		System.out.println(coinChange(coins, amount));
		//minCoinsRequired(coins,amount);
	}

}
