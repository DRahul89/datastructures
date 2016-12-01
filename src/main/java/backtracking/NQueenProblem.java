package main.java.backtracking;

/**
 * problem is placing N queen to N column so that no two queen interfere each
 * other
 * 
 * algo if all queen placed return true else start putting from first col try
 * every row and if find any placerd recur for this move for sol
 * 
 * 
 * @author rdixi7
 *
 */
public class NQueenProblem {

	/**
	 * check if the movement of knight is safe or not
	 * 
	 * @param chessBoard
	 * @param row
	 * @param col
	 * @return
	 */
	public static boolean isSafe(int[][] sol, int n, int row, int col) {
		// for all columns till this column in the same row
		for (int i = col; i >= 0; i--) {
			if (sol[row][i] == 1)
				return false;
		}

		// for upper diagonal on left side
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (sol[i][j] == 1)
				return false;
		}

		// for lower diagonal
		for (int i = row, j = col; j >= 0 && i < sol.length; i++, j--) {
			if (sol[i][j] == 1)
				return false;
		}
		return true;
	}

	/**
	 * print the knight tour
	 * 
	 * @param chessBoard
	 */
	public static void printSol(final int[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean nQueenProblem(int[][] queens, int N, int col) {
		if (col >= N) {
			printSol(queens);
			return true;
		}
		for (int i = 0; i < N; i++) {
			if (isSafe(queens, queens.length, i, col)) {
				queens[i][col] = 1;
				if (nQueenProblem(queens, N, col + 1)) {
					return true;
				} else {
					queens[i][col] = 0;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int queens[][] = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		nQueenProblem(queens, 4, 0);
	}
}
