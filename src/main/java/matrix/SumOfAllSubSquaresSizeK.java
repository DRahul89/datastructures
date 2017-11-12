package main.java.matrix;

/**
 * algo is all vertical strip k*0 of tis matrix and then use this value to
 * calculate the sum
 * 
 * @author rdixi3
 *
 */
public class SumOfAllSubSquaresSizeK {

	public static void sumOfKSubMatrix(int[][] matrix, int n, int k) {
		int[][] temp = new int[n - k + 1][n];
		for (int j = 0; j < n; j++) {
			int sum = 0;
			for (int i = 0; i < k; i++) {
				sum = sum + matrix[i][j];
			}
			temp[0][j] = sum;
			for (int i = 1; i < n - k + 1; i++) {
				sum = sum + (matrix[i + k - 1][j] - matrix[i - 1][j]);
				temp[i][j] = sum;
			}
		}
		for (int i = 0; i < n - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum = sum + temp[i][j];
			}
			System.out.print(sum + " ");
			for (int j = 1; j < n - k + 1; j++) {
				sum = sum + (temp[i][j + k - 1] - temp[i][j - 1]);
				System.out.print(sum + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4 },
				{ 5, 5, 5, 5, 5 }, };
		int k = 3;
		sumOfKSubMatrix(mat, 5, 3);
	}
}
