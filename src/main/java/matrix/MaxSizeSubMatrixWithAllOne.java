package main.java.matrix;

public class MaxSizeSubMatrixWithAllOne {

	/**
	 * craete a parallel 2d array t[][] where t[i][j] will be the size of max
	 * submatrix with all one including input[i][j] where input[i][j] will be
	 * rightmost bottom most entry in sub matrix now for all element do this if
	 * input[i][j]=1 t[i][j]=min(t[i-1][j],t[i][j-1],t[i-1][j-1])+1 else
	 * t[i][j]=0
	 * 
	 * now find max of t[i][j] and indexes and print the matrix
	 */
	public static void maxSizeSubMatrixWithAllOne(int[][] input, int m, int n) {
		int maxVal = -1;
		int rIndex = -1;
		int cIndex = -1;
		int[][] t = new int[m][n];
		for (int i = 0; i < m; i++) {
			t[i][0] = input[i][0];
		}
		for (int j = 0; j < n; j++) {
			t[0][j] = input[0][j];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (input[i][j] == 1) {
					int min = 100;
					if (t[i - 1][j] < t[i][j - 1]) {
						min = t[i - 1][j];
					} else {
						min = t[i][j - 1];
					}
					t[i][j] = Math.min(min, t[i - 1][j - 1]) + 1;
				} else {
					t[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i][j] > maxVal) {
					maxVal = t[i][j];
					rIndex = i;
					cIndex = j;
				}
			}
		}

		System.out.println("Maximum size sub-matrix is: ");
		for (int i = rIndex; i > rIndex - maxVal; i--) {
			for (int j = cIndex; j > cIndex - maxVal; j--) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        maxSizeSubMatrixWithAllOne(M, 6, 5);
	}
}
