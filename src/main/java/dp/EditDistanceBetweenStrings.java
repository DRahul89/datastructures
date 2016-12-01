package main.java.dp;

/**
 * algo is find min cost for all three operations and then optimal sol convert
 * thius recursion to DP
 * 
 * @author rdixi7
 *
 */
public class EditDistanceBetweenStrings {
	/*
	 * min distance to convert first string to second by insert ,remove and
	 * replace
	 */
	public static int editDistance(String first, String second, int m, int n) {
		if (m == 0)// insert all second to first N
			return n;
		if (n == 0)// remove all from first
			return m;
		if (first.charAt(m - 1) == second.charAt(n - 1))
			return editDistance(first, second, m - 1, n - 1);

		return 1 + min(editDistance(first, second, m - 1, n), editDistance(first, second, m, n - 1),
				editDistance(first, second, m - 1, n - 1));// remove , add and
															// replace
	}

	/*
	 * min distance to convert first string to second by insert ,remove and
	 * replace
	 */
	public static int editDistanceDP(String first, String second, int m, int n) {
		int[][] dist = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dist[i][j] = j;
				} else if (j == 0) {
					dist[i][j] = i;
				} else if (first.charAt(i - 1) == second.charAt(j - 1))
					dist[i][j] = dist[i - 1][j - 1];
				else
					dist[i][j] = 1 + min(dist[i][j - 1], dist[i - 1][j], dist[i - 1][j - 1]);

			}
		}
		return dist[m][n];
	}

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

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDistanceDP(str1, str2, str1.length(), str2.length()));
	}

}
