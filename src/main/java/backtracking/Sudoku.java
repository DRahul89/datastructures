package main.java.backtracking;

/**
 * problem is a 9*9 partially filled matrix we have to put numbers from 1 to 9
 * so that no row ,col and 3*3 box contains duplicates
 * 
 * @author
 *
 */
public class Sudoku {
	/**
	 * algo is based on back tracking first decide one sol go for it otherwise
	 * backtrack read comments for more clarity
	 * 
	 * @param sudokuArr
	 * @return
	 */
	public static boolean sudoku(int[][] sudokuArr) {
		Point point = new Point();
		if (allCellFilled(sudokuArr, point))
			return true;

		for (int i = 1; i <= 9; i++) {
			if (isSafe(sudokuArr, point.x, point.y, i)) {
				// make an tentative assignment
				sudokuArr[point.x][point.y] = i;
				if (sudoku(sudokuArr))
					return true;
				sudokuArr[point.x][point.y] = 0; // back tracking
			}

		}
		return false;// triggers the back tracking
	}

	public static boolean isNumberExistsInRow(int[][] sudokuArr, int row, int num) {
		for (int i = 0; i < sudokuArr.length; i++) {
			if (sudokuArr[row][i] == num)
				return true;
		}
		return false;
	}

	public static boolean isNumberExistsInCol(int[][] sudokuArr, int col, int num) {
		for (int i = 0; i < sudokuArr.length; i++) {
			if (sudokuArr[i][col] == num)
				return true;
		}
		return false;
	}

	public static boolean isNumberExistsInSubMatrix(int[][] sudokuArr, int startRow, int startCol, int size, int num) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (sudokuArr[i + startRow][j + startCol] == num)
					return true;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] sudokuArr, int x, int y, int num) {
		return !isNumberExistsInRow(sudokuArr, x, num) && !isNumberExistsInCol(sudokuArr, y, num)
				&& !isNumberExistsInSubMatrix(sudokuArr, x - x % 3, y - y % 3, 3, num);
	}

	private static boolean allCellFilled(int[][] sudokuArr, Point point) {
		for (int i = 0; i < sudokuArr.length; i++) {
			for (int j = 0; j < sudokuArr[0].length; j++) {
				if (sudokuArr[i][j] == 0) {
					point.x = i;
					point.y = j;
					return false;
				}
			}

		}
		return true;
	}

	public static void printGrid(int grid[][], int N) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++)
				System.out.print(grid[row][col]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int grid[][] = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		if (sudoku(grid)) {
			printGrid(grid, 9);
		}
	}

}
