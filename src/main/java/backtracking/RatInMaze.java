package main.java.backtracking;
/**
 * read from geeksfr geeks
 * @author rdixi7
 *
 */
public class RatInMaze {

	/**
	 * check if the movement of knight is safe or not
	 * 
	 * @param chessBoard
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isSafe(int[][] sol, int n, int row, int col) {

		return (row >= 0 && row < n && col >= 0 && col < n && sol[row][col] == 1);
	}

	/**
	 * print the knight tour
	 * 
	 * @param sol
	 */
	public static void printTour(final int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean solveMaze(int x, int y, int n, int[][] sol, int[][] maze) {
		if (x == n - 1 && y == n - 1) {
			sol[x][y]=1;
			printTour(sol);
			return true;
		}

		if (isSafe(maze, n, x, y)) {
			sol[x][y] = 1;
			if (solveMaze(x, y + 1, n, sol, maze))
				return true;

			if (solveMaze(x + 1, y, n, sol, maze))
				return true;

			sol[x][y] = 0;
			return false;
		}
		return false;// back
						// tracking
						// triggers
						// here
	}

	public static void main(String[] args) {
		int maze[][] = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		int[][] sol = new int[4][4];
		solveMaze(0,0,4,sol,maze);
	}

}
