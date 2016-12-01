package main.java.dp;

/**
 * c(n,0)=c(n,n)=1 c(n,r)=c(n-1,r-1)+c(n-1,r)
 * 
 * @author rdixi7
 *
 */
public class BinomialCoefficient {

	public static int binaomialValue(int n, int k) {
		if (k == 0 || n == k)
			return 1;
		return binaomialValue(n - 1, k - 1) + binaomialValue(n - 1, k);

	}

	/**
	 * Now one imp thing this can be optimize bcz in this coef[i][j] = coef[i -
	 * 1][j - 1] + coef[i - 1][j] the i dimension is always fix
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int binaomialValueDP(int n, int k) {
		int[][] coef = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0 || i == j) {
					coef[i][j] = 1;
				} else {
					coef[i][j] = coef[i - 1][j - 1] + coef[i - 1][j];
				}
			}
		}
		return coef[n][k];

	}

	public static void main(String[] args) {
		System.out.println(binaomialValue(10, 2));
		System.out.println(binaomialValueDP(9, 2));
	}

}
