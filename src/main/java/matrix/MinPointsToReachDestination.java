package main.java.matrix;

/**
 * Given a grid with each cell consisting of positive, negative or no points
 * i.e, zero points. We can move across a cell only if we have positive points (
 * > 0 ). Whenever we pass through a cell, points in that cell are added to our
 * overall points. We need to find minimum initial points to reach cell (m-1,
 * n-1) from (0, 0).
 * 
 * Constraints :
 * 
 * From a cell (i, j) we can move to (i+1, j) or (i, j+1). We cannot move from
 * (i, j) if your overall points at (i, j) is <= 0. We have to reach at (n-1,
 * m-1) with minimum positive points i.e., > 0.
 * 
 * @author rdixi3
 *
 */
public class MinPointsToReachDestination {

	/**
	 * We can solve this problem through bottom-up table filling dynamic
	 * programing technique.
	 * 
	 * To begin with, we should maintain a 2D array dp of the same size as the
	 * grid, where dp[i][j] represents the minimum points that guarantees the
	 * continuation of the journey to destination before entering the cell (i,
	 * j). It’s but obvious that dp[0][0] is our final solution. Hence, for this
	 * problem, we need to fill the table from the bottom right corner to left
	 * top. Now, let us decide minimum points needed to leave cell (i, j)
	 * (remember we are moving from bottom to up). There are only two paths to
	 * choose: (i+1, j) and (i, j+1). Of course we will choose the cell that the
	 * player can finish the rest of his journey with a smaller initial points.
	 * Therefore we have: min_Points_on_exit = min(dp[i+1][j], dp[i][j+1])
	 * 
	 * @param matrix
	 * @return
	 */
	public static int minPointsBottomUpAproach(int[][] matrix, int m, int n) {
		int[][] dp = new int[m][n];
		// base case
		dp[m - 1][n - 1] = matrix[m - 1][n - 1] > 0 ? 1 : Math.abs(matrix[m - 1][n - 1] )+ 1;
		// now fill last row and last column
		for (int i = m - 2; i >= 0; i--)
			dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - matrix[i][n - 1], 1);
		for (int j = n - 2; j >= 0; j--)
			dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - matrix[m - 1][j], 1);
		
		for (int i = m - 2; i >= 0; i--){
			for (int j = n - 2; j >= 0; j--){
				int minPoints=Math.min(dp[i+1][j],dp[i][j+1]);
				dp[i][j]=Math.max(minPoints - matrix[i][j], 1);
			}
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int points[][] = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
              };
		System.out.println(minPointsBottomUpAproach(points, 3, 3));
	}
}
