package main.java.dp;

/**
 * problem is {10,5,4} sum 9 then true (5,4) another version of knapsack problem
 * this can also be used for partitioning problem {1,5,5,11} algo is cal whole
 * sum if even then find subset sum for sum/2 if true then true else false
 * 
 * @author rdixi7
 *
 */
public class SubsetSumProblem {

	public static boolean isSubsetSumExists(int[] set, int n, int amount) {
		if (amount == 0)
			return true;
		if (amount > 0 && n <= 0)
			return false;

		if (set[n - 1] > amount)
			return isSubsetSumExists(set, n - 1, amount);

		return isSubsetSumExists(set, n - 1, amount) || isSubsetSumExists(set, n - 1, amount - set[n - 1]);
	}

	public static boolean subsetSumDP(int[] set, int amount) {
		boolean[][] table = new boolean[amount + 1][set.length + 1];
		for (int i = 0; i < set.length + 1; i++)
			table[0][i] = true;
		for (int i = 1; i < amount + 1; i++)
			table[i][0] = false;

		for (int i = 1; i < amount + 1; i++) {
			for (int j = 1; j < set.length + 1; j++) {
				table[i][j] = table[i][j - 1];
				if (i - set[j - 1] >= 0)
					table[i][j] = table[i][j] || table[i - set[j - 1]][j - 1];
			}
		}
		return table[amount][set.length];
	}

	public static void main(String[] args) {
		int[] set = { 10, 4, 5 };
		// System.out.println(isSubsetSumExists(set, 3, 9));
		System.out.println(subsetSumDP(set, 19));
	}
}
