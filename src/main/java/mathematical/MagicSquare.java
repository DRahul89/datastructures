package main.java.mathematical;

/**
 * start from (n/2,n-1) then (i-1,j+1) and 3 conditions (i) if calculated row
 * become -1 it will be n-1 if calculated column become n it will be 0 (ii)if
 * calculated already fill then move to (i+1,j-2) (iii)if calculated row become
 * -1 and column is n then it will be (0,n-2)``
 * 
 * @author rahul2065
 *
 */
public class MagicSquare {

	public static void printMagicSquare(int size) {
		int[][] magicSquare = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				magicSquare[i][j] = -1;
			}
		}
		int rowIndex = size / 2;
		int columnIndex = size - 1;
		for (int num = 1; num <= size * size; num++) {
			if (rowIndex == -1 && columnIndex == size) {
				rowIndex = 0;
				columnIndex = size - 2;
			}

			if (rowIndex < 0) {
				rowIndex = size - 1;
			}

			if (columnIndex == size) {
				columnIndex = 0;
			}
			if (magicSquare[rowIndex][columnIndex] != -1) {
				rowIndex++;
				columnIndex = columnIndex - 2;
			}
			if (magicSquare[rowIndex][columnIndex] == -1) {
				magicSquare[rowIndex][columnIndex] = num;
			}

			rowIndex--;
			columnIndex++;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(magicSquare[i][j]);
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		printMagicSquare(5);
	}


}
