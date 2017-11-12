package main.java.matrix;

/**
 * Given a n*n matrix where all numbers are distinct, find the maximum length
 * path (starting from any cell) such that all cells along the path are in
 * increasing order with a difference of 1.
 * 
 * We can move in 4 directions from a given cell (i, j), i.e., we can move to
 * (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the
 * adjacent cells have a difference of 1.
 * 
 * 
 * solution for each cell calculate path length and return max but there will be
 * a lot of overlaping in this case so use memoization
 * 
 * @author rdixi3
 *
 */
public class LongestPathMatrix {

	public static int longestPathForEachCell(int row, int col, int[][] mat, int[][] dp) {
		if (row < 0 || row >= mat.length || col < 0 || col >= mat.length)
			return 0;
		if (dp[row][col] != -1)
			return dp[row][col];

		if (row > 0 && (mat[row][col] + 1 == mat[row - 1][col])) {
			dp[row][col] = 1 + longestPathForEachCell(row - 1, col, mat, dp);
			return dp[row][col];
		}
		if (row < mat.length -1 && (mat[row][col] + 1 == mat[row + 1][col])) {
			dp[row][col] = 1 + longestPathForEachCell(row + 1, col, mat, dp);
			return dp[row][col];
		}
		if (col > 0 && (mat[row][col] + 1 == mat[row][col - 1])) {
			dp[row][col] = 1 + longestPathForEachCell(row, col - 1, mat, dp);
			return dp[row][col];
		}
		if (col < mat.length -1 && (mat[row][col] + 1 == mat[row][col + 1])) {
			dp[row][col] = 1 + longestPathForEachCell(row, col + 1, mat, dp);
			return dp[row][col];
		}
		return (dp[row][col] = 1);
	}

	public static int longestPath(int[][] mat, int n) {
		int[][] dp = new int[n][n];
		int result = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == -1) {
					longestPathForEachCell(i,j,mat,dp);
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int  mat[][] = { {1, 10, 9},
                {5, 3, 8},
                {4, 6, 7} };
System.out.println("Length of the longest path is " + 
		longestPath(mat,3));
	}
}
