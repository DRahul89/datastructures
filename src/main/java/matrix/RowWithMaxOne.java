package main.java.matrix;

public class RowWithMaxOne {
	/**
	 * second approach is to use binary search to find first one in each row and
	 * return max 1
	 * 
	 * @param matrix
	 * @param m
	 * @param n
	 * @return
	 */
	public static int rowWithMaxOne(int[][] matrix, int m, int n) {
		int minZero = 100;
		int maxOneIndex = -1;
		for (int i = 0; i < m; i++) {
			int zeroCount = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					break;
				}
				zeroCount++;
			}
			if (zeroCount < minZero) {
				minZero = zeroCount;
				maxOneIndex = i;
			}

		}
		return maxOneIndex;
	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.println(rowWithMaxOne(mat, 4, 4));

	}
}
