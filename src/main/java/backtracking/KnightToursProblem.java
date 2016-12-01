package main.java.backtracking;

/**
 * a knight tour problem is where a knight would start from a point and move to
 * whole chess board all cells only once and if it reach to from where it
 * started tour is closed otherwise its open
 * 
 * @author rdixi7
 *
 */
public class KnightToursProblem {
	/**
	 * check if the movement of knight is safe or not
	 * 
	 * @param chessBoard
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isSafe(int[][] sol, int n, int row, int col) {

		return (row >= 0 && row < n && col >= 0 && col < n && sol[row][col] == -1);
	}

	/**
	 * print the knight tour
	 * 
	 * @param chessBoard
	 */
	public static void printTour(final int[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				System.out.print(chessBoard[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static boolean knightTourCreation(int x, int y, int n, int move, int[][] sol) {
		if (move == n * n) {
			printTour(sol);
			return true;
		}
		int xLoc[] = { -2, -1, 1, 2, 1, 2, -2, -1 };
		int yLoc[] = { 1, 2, 2, 1, -2, -1, -1, -2 };
		int nextX = 0;
		int nextY = 0;
		for (int i = 0; i < xLoc.length; i++) {
			nextX = x + xLoc[i];
			nextY = y + yLoc[i];
			if (isSafe(sol, n, nextX, nextY)) {
				sol[nextX][nextY] = move;
				if (knightTourCreation(nextX, nextY, n, move + 1, sol))
					return true;
				else
					sol[nextX][nextY] = -1;
			}
		}
		return false;// back tracking triggers here
	}

	public static void main(String[] args) {
		int[][] sol = new int[8][8];
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				sol[i][j] = -1;
			}
		}
		sol[0][0] = 0;
		knightTourCreation(0, 0, 8, 1, sol);
	}
}
