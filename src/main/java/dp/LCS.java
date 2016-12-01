package main.java.dp;

/**
 * largest common subsequence for <ABCDGH> <AEDFH> largest common subsequence
 * ADH
 * 
 * @author rdixi7
 *
 */
public class LCS {
	/**
	 * largest common subsequence
	 * 
	 * @param x
	 * @param y
	 * @param m
	 *            length of x
	 * @param n
	 *            length of y
	 * @return
	 */
	public static int lcsRecursive(char[] x, char[] y, int m, int n) {
		if (m < 0 || n < 0)
			return 0;

		if (x[m] == y[n]) {
			return 1 + lcsRecursive(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcsRecursive(x, y, m - 1, n), lcsRecursive(x, y, m, n - 1));
		}
	}

	/**
	 * x[0 to m-1] y[0 to n-1]
	 * 
	 * @param x
	 * @param y
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcsByDynamicProgramming(char[] x, char[] y, int m, int n) {
		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}

			}
		}

		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (x[i - 1] == y[j - 1]) {
				System.out.print(x[i - 1]);
				i--;
				j--;
			} else if (lcs[i][j - 1] > lcs[i - 1][j]) {
				j--;
			} else {
				i--;
			}
		}
		return lcs[m][n];
	}

	public static void main(String[] args) {
		char X[] = { 'A', 'G', 'G', 'T', 'A', 'B' };
		char Y[] = { 'G', 'X', 'T', 'X', 'A', 'Y', 'B' };

		System.out.println(lcsRecursive(X, Y, X.length - 1, Y.length - 1));
		System.out.println(lcsByDynamicProgramming(X, Y, X.length, Y.length));
	}

}
