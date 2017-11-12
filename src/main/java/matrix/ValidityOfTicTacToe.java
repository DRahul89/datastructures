package main.java.matrix;

/**
 * assumption player x start the game so if x win then no of X's +1 = no of O's
 * so if o win then no of X's = no of O's if no one win then no X's +1 = no of
 * O's
 * 
 * @author rdixi3
 *
 *
 *         1) countX == countO or countX == countO + 1 2) If O is in win
 *         condition then check a) If X also wins, not valid b) If xbox != obox
 *         , not valid 3) If X is in win condition then check if xCount is one
 *         more than oCount or not
 */
public class ValidityOfTicTacToe {

	static int winCases[][] = { { 0, 1, 2 }, // Check first row.
			{ 3, 4, 5 }, // Check second Row
			{ 6, 7, 8 }, // Check third Row
			{ 0, 3, 6 }, // Check first column
			{ 1, 4, 7 }, // Check second Column
			{ 2, 5, 8 }, // Check third Column
			{ 0, 4, 8 }, // Check first Diagonal
			{ 2, 4, 6 } };

	public static boolean isPlayerWin(char[] game, char player) {
		for (int i = 0; i < 8; i++) {
			if (game[winCases[i][0]] == player && game[winCases[i][1]] == player && game[winCases[i][2]] == player)
				return true;
		}
		return false;
	}

	public static boolean isValid(char[] board) {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X')
				xCount++;
			else
				oCount++;
		}

		if (xCount == oCount || (xCount == oCount +1)) {
			if (isPlayerWin(board, 'O')) {
				if (isPlayerWin(board, 'X'))
					return false;
				if (xCount != oCount)
					return false;
			}
			if (isPlayerWin(board, 'X')) {
				if (xCount + 1 != oCount)
					return false;
			}

			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		char board[] = { 'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X' };
		System.out.println(isValid(board));
	}
}
