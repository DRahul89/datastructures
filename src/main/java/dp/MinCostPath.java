package main.java.dp;

/**
 * min cost from (0,0) to (m,n) in a matrix if you can move only left right and
 * diagonally
 * 
 * @author rdixi7
 *
 */
public class MinCostPath {

	private static int min(int editDistance, int editDistance2, int editDistance3) {
		int min = -1;
		if (editDistance < editDistance2) {
			min = editDistance;
		} else {
			min = editDistance2;
		}
		if (min > editDistance3)
			min = editDistance3;
		return min;
	}

	/**
	 * min cost should be min of (m-1,n),(m,n-1),(m-1,n-1)
	 * 
	 * @param cost
	 * @param m
	 * @param n
	 * @return
	 */
	public static int minCostRecursive(int[][] cost, int m, int n) {
		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;
		if (m == 0 && n == 0)
			return cost[0][0];

		return cost[m][n] + min(minCostRecursive(cost, m - 1, n), minCostRecursive(cost, m, n - 1),
				minCostRecursive(cost, m - 1, n - 1));

	}

	public static int minCostDP(int[][] cost, int m, int n) {
		int[][] tc = new int[m + 1][n + 1];
		tc[0][0] = cost[0][0];
		for (int i = 1; i <= m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];
		for (int j = 1; j <= n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				tc[i][j] = cost[i][j] + min(tc[i][j - 1], tc[i - 1][j], tc[i - 1][j - 1]);
			}
		}
		return tc[m][n];
	}

	/**
	 * now min initial points
	 * 
	 * @param args
	 */
	public static int minInitialPoints(int[][] cost, int m, int n) {
		if (m == cost.length && n == cost.length)
			return 0;
		if (m >= cost.length || n >= cost.length)
			return 0;

		int val = cost[m][n] > 0 ? 0 : cost[m][n];
		return Math.max(val + minInitialPoints(cost, m + 1, n), val + minInitialPoints(cost, m, n + 1));
	}

	public static void main(String[] args) {
		int cost[][] = new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int points[][] = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		// System.out.println(minCostDP(cost, 2, 2));
		System.out.println(minInitialPoints(points, 0, 0));
	}
}
