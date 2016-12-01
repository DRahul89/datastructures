package main.java.dp;

/**
 * fractional knapsack can be solved by greedy but [0/1] knapsack can be solved
 * by only DP
 * 
 * @author rdixi7
 *
 */
public class KnapsackProblem {

	public static int knapsackValue(int[] wt, int[] val, int w, int n) {

		if (w == 0 || n == 0)
			return 0;

		if (wt[n - 1] > w)
			return knapsackValue(wt, val, w, n - 1);

		return Math.max(knapsackValue(wt, val, w, n - 1), val[n - 1] + knapsackValue(wt, val, w - wt[n - 1], n - 1));
	}

	public static int knapsackValueDP(int[] wt, int[] val, int W, int n) {
		int[][] table = new int[W + 1][n + 1];

		for (int w = 0; w <= W; w++) {
			for (int j = 0; j <= n; j++) {
				if (w == 0 || j == 0) {
					table[w][j] = 0;
				} else if (w - wt[j - 1] >= 0) {
					table[w][j] = Math.max(val[j - 1] + table[w - wt[j - 1]][j - 1], table[w][j - 1]);
				} else {
					table[w][j] = table[w][j - 1];
				}
			}
		}
		return table[W][n];
	}

	public static void main(String[] args) {
		/*
		 * int val[] = new int[] { 60, 100, 120 }; int wt[] = new int[] { 10,
		 * 20, 30 }; int W = 50; int n = val.length;
		 */

		int val[] = new int[] { 1, 1, 1 };
		int wt[] = new int[] { 25, 10, 5 };
		int W = 30;
		int n = val.length;
		System.out.println(knapsackValue(wt, val, W, n));
	}

}
