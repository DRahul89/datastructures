package main.java.dp;

public class CoinChangeProblem {

	public static int coinChangeCount(int[] coins, int len, int val) {
		if (val == 0)// no coin include one solution exists
			return 1;
		if (val < 0)
			return 0;

		if (len <= 0)
			return 0;

		return coinChangeCount(coins, len, val - coins[len - 1]) + coinChangeCount(coins, len - 1, val);

	}

	public static int coinChangeCountDP(int[] coins, int len, int val) {
		int[][] table = new int[val + 1][len];
		for (int i = 0; i < len; i++)
			table[0][i] = 1;
		for (int i = 1; i < val + 1; i++) {
			for (int j = 0; j < len; j++) {
				int x = (i - coins[j] >= 0) ? table[i - coins[j]][j] : 0; // including
																			// j
				int y = (j >= 1) ? table[i][j - 1] : 0;// exclude j
				table[i][j] = x + y;

			}
		}
		return table[val][len - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		System.out.println(coinChangeCountDP(arr, m, n));

	}
}
