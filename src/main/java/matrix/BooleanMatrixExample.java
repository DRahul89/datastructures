package main.java.matrix;

/**
 * if mat[i][j] contains 1 then mark ith row 1 and jth col 1 algo use first row
 * and colo for storing the info scan once and store info about such row and
 * column then scan again and fill
 * 
 * @author rdixi3
 *
 */
public class BooleanMatrixExample {

	public static void booleanMatrixProblem(int[][] matrix, int m, int n) {
		boolean rowFlag = Boolean.FALSE;
		boolean colFlag = Boolean.FALSE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 && matrix[i][j] == 1)
					rowFlag = Boolean.TRUE;
				if (j == 0 && matrix[i][j] == 1)
					colFlag = Boolean.TRUE;

				if (matrix[i][j] == 1) {
					matrix[0][j] = 1;
					matrix[i][0] = 1;
				}
			}

		}

		for (int i = 1; i < m; i++) {

			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 1) {
					matrix[i][j] = 1;
				}
				if (matrix[0][j] == 1) {
					matrix[i][j] = 1;
				}

			}

		}

		if (rowFlag) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 1;
			}
		}
		if (colFlag) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 1;
			}
		}

		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		booleanMatrixProblem(mat,3,4);

	}
}
