package main.java.matrix;

public class PrintSpiralOrDiagonal {

	public static void printSpiral(final int[][] input, int m, int n) {
		int k = 0;
		int l = 0;
		while (k < m && l < n) {
			// print first row in remaining column
			for (int i = l; i < n; i++) {
				System.out.print(input[k][i] + " ");
			}
			k++;
			// print last column in remaining row
			for (int i = k; i < m; i++) {
				System.out.print(input[i][n - 1] + " ");
			}
			n--;
			if (k < m) {
				// print last row in remaining column
				for (int i = n - 1; i >= l; i--) {
					System.out.print(input[m - 1][i] + " ");
				}
				m--;
			}
			if (l < n) {
				// print first column in remaining row
				for (int i = m - 1; i >= k; i--) {
					System.out.print(input[i][l] + " ");
				}
				l++;
			}

		}
	}

	public static boolean isValid(int row, int col, int i, int j) {
		
		if (i < 0 || i >= row || j < 0 || j >= col)
			return false;

		return true;
	}

	/**
	 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
	 * 
	 * output
	 * 
	 * 1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20
	 * 
	 * @param input
	 * @param m
	 * @param n
	 */
	public static void printDiagonal(final int[][] input, int m, int n) {
		//this loop to print all rows of diagonal for zero column
		for(int i=0;i<m;i++){
			System.out.print(input[i][0]+" ");
			int rowIndex = i-1;
			int colIndex = 1;
			while(isValid(m,n,rowIndex,colIndex)){
				System.out.print(input[rowIndex][colIndex]+" ");
				rowIndex--;
				colIndex++;
			}
			System.out.println("");
		}
		
		//this loop to print all rows of diagonal for zero column
				for(int j=1;j<n;j++){
					System.out.print(input[m-1][j]+" ");
					int rowIndex = m-2;
					int colIndex = j+1;
					while(isValid(m,n,rowIndex,colIndex)){
						System.out.print(input[rowIndex][colIndex]+" ");
						rowIndex--;
						colIndex++;
					}
					System.out.println("");
				}
	}

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		//printSpiral(a, R, C);
		int arr[][] = {{1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16},
		        {17, 18, 19, 20},
		    };
		printDiagonal(arr, 5, 4);
	}
}
